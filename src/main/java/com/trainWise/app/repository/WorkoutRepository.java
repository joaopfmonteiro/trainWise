package com.trainWise.app.repository;

import com.trainWise.app.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository <Workout, Long> {
}
