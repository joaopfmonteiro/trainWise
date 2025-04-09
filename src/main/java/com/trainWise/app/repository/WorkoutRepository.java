package com.trainWise.app.repository;

import com.trainWise.app.dto.CurrentWorkoutDto;
import com.trainWise.app.dto.WorkoutDto;
import com.trainWise.app.model.Workout;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository <Workout, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRAINING_UNIT SET workout_id = :workoutId WHERE id = :trainingId", nativeQuery = true)
    void addTrainingUnitToWorkout(@Param("workoutId") Long workoutId, @Param("trainingId") Long trainingId);


    @Query("SELECT new com.trainWise.app.dto.WorkoutDto(tu.reps, tu.set, tu.weight, w.day, e.name) " +
            "FROM TrainingUnit tu " +
            "JOIN tu.workout w " +
            "LEFT JOIN tu.exercise e " +
            "WHERE w.id = :workoutId")
    List<WorkoutDto> findTrainingUnitDetailsByWorkoutId(@Param("workoutId") Long workoutId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE WORKOUT SET self_trainer_id = :self_trainer_id " +
            "WHERE id = :workout_id", nativeQuery = true)
    void addWorkoutToUser(@Param("workout_id") Long self_trainer_id, @Param("self_trainer_id") Long workout_id);

    @Query(value = """
    SELECT 
        e.name AS name,
        e.equipment AS equipment,
        tu.reps AS reps,
        tu.set AS set,
        tu.weight AS weight,
        tu.rest AS rest,
        w.day AS day
    FROM self_trainer st
    INNER JOIN workout w ON st.id = w.self_trainer_id
    INNER JOIN training_unit tu ON w.id = tu.workout_id
    INNER JOIN exercise e ON tu.exercise_id = e.id
    WHERE st.id = :id
      AND w.day = (
          SELECT MIN(w2.day)
          FROM workout w2
          WHERE w2.self_trainer_id = :id
            AND w2.day >= CURRENT_DATE
      )
    ORDER BY w.day ASC
    """, nativeQuery = true)
    List<CurrentWorkoutDto> findFirstWorkoutByDayAndUser(@Param("id") Long id);

}
