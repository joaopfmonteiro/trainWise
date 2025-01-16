package com.trainWise.app.service;

import com.trainWise.app.model.Exercise;
import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.repository.ExerciseRepository;
import com.trainWise.app.repository.TrainingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingUnitService {

    @Autowired
    TrainingUnitRepository trainingUnitRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<TrainingUnit> getAll(){
        return trainingUnitRepository.findAll();
    }

    public TrainingUnit createTrainingUnit(TrainingUnit trainingUnit){
        return trainingUnitRepository.save(trainingUnit);
    }

    public TrainingUnit addExerciseToTrainingUnit(Long trainingUnitId, Long exerciseId){

        TrainingUnit trainingUnit = trainingUnitRepository.findById(trainingUnitId)
                .orElseThrow(() -> new RuntimeException("training Unit not found"));

        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise id not found"));

        exercise.setTrainingUnits(trainingUnit);
        trainingUnit.setExercise(exercise);

        return trainingUnitRepository.save(trainingUnit);
    }

    public void updateTrainingUnit(TrainingUnit trainingUnit){
         trainingUnitRepository.save(trainingUnit);
    }

    public List<TrainingUnit> getTrainingUnitsByWorkout(Long workoutId){
        return trainingUnitRepository.findTrainingUnitsByWorkout(workoutId);
    }
}
