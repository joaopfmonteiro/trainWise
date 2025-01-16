package com.trainWise.app.service;

import com.trainWise.app.dto.ExerciseMuscleDto;
import com.trainWise.app.dto.ExerciseNameDto;
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

    public List<ExerciseNameDto> searchByName(String exerciseName){
        return exerciseRepository.searchExercisesName(exerciseName);
    }

    public List<ExerciseMuscleDto> searchByMuscle(String exerciseMuscle){
        return exerciseRepository.searchExercisesMuscle(exerciseMuscle);
    }

    public List<ExerciseNameDto> orderByName(){
        return exerciseRepository.orderByName();
    }

    public List<ExerciseMuscleDto> oderByMuscle(){
        return exerciseRepository.orderByMuscle();
    }

}
