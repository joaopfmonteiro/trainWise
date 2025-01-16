package com.trainWise.app.service;

import com.trainWise.app.dto.WorkoutDto;
import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.model.Workout;
import com.trainWise.app.repository.TrainingUnitRepository;
import com.trainWise.app.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    TrainingUnitRepository trainingUnitRepository;

    public Workout createWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public void updateWorkout(Workout workout){
        workoutRepository.save(workout);
    }

    @Transactional
    public void addTrainingUnitToWorkout(Long workoutId, Long trainingId) {
        if (!workoutRepository.existsById(workoutId)) {
            throw new RuntimeException("Workout not found with id: " + workoutId);
        }

        if (!trainingUnitRepository.existsById(trainingId)) {
            throw new RuntimeException("TrainingUnit not found with id: " + trainingId);
        }

        workoutRepository.addTrainingUnitToWorkout(workoutId, trainingId);
    }

    public List<WorkoutDto> getTrainingUnitsByWorkout(Long workoutId){
        return workoutRepository.findTrainingUnitDetailsByWorkoutId(workoutId);
    }
}
