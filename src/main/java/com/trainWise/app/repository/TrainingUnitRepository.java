package com.trainWise.app.repository;

import com.trainWise.app.model.TrainingUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TrainingUnitRepository extends JpaRepository<TrainingUnit, Long> {

    @Query("SELECT t FROM Workout w " +
            "JOIN w.trainingUnit t " +
            "WHERE w.id = :workoutId")
    List<TrainingUnit> findTrainingUnitsByWorkout(@PathVariable("workoutId") Long workoutId);
}
