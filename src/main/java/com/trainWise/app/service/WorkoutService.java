package com.trainWise.app.service;

import com.trainWise.app.model.Workout;
import com.trainWise.app.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    public Workout createWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public void updateWorkout(Workout workout){
        workoutRepository.save(workout);
    }
}
