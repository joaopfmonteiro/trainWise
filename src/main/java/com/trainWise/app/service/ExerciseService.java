package com.trainWise.app.service;

import com.trainWise.app.model.Exercise;
import com.trainWise.app.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> getAll(){
        return exerciseRepository.findAll();
    }

    public Exercise createExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    public void update(Exercise exercise){
        exerciseRepository.save(exercise);
    }

}
