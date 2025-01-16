package com.trainWise.app.repository;

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


}
