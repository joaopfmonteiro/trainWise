package com.trainWise.app.service;

import com.trainWise.app.dto.ExerciseMuscleDto;
import com.trainWise.app.dto.ExerciseNameDto;
import com.trainWise.app.model.Exercise;
import com.trainWise.app.model.enums.ExerciseEquipment;
import com.trainWise.app.model.enums.ExerciseType;
import com.trainWise.app.model.enums.Muscle;
import com.trainWise.app.model.enums.MuscleGroup;
import com.trainWise.app.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Exercise> getExercisesByEquipment(List<String> equipments) {
        List<ExerciseEquipment> equipmentEnums = equipments.stream()
                .map(e -> ExerciseEquipment.valueOf(e.toUpperCase()))
                .collect(Collectors.toList());
        List<Exercise> exercises = exerciseRepository.filterByEquipment(equipmentEnums);

        return exercises;
    }

    public List<Exercise> getExercisesByExerciseType(List<String> exerciseTypes) {
        List<ExerciseType> exerciseTypeEnums = new ArrayList<>();

        for (String type : exerciseTypes) {
            exerciseTypeEnums.add(ExerciseType.valueOf(type.toUpperCase()));
        }

        return exerciseRepository.filterByExerciseType(exerciseTypeEnums);
    }

    public List<Exercise> getExercisesByExerciseMuscle(List<String> muscles) {
        List<Muscle> musclesEnum = new ArrayList<>();

        for(String muscle : muscles){
            musclesEnum.add(Muscle.valueOf(muscle.toUpperCase()));
        }
        return exerciseRepository.filterByMuscle(musclesEnum);
    }

    public List<Exercise> getExercisesByExerciseMuscleGroup(List<String> muscles) {
        List<MuscleGroup> musclesEnum  = new ArrayList<>();

        for(String muscle : muscles){
            musclesEnum .add(MuscleGroup.valueOf(muscle.toUpperCase()));
        }
        return exerciseRepository.filterByMuscleGroup(musclesEnum);
    }

    public List<ExerciseNameDto> orderByName(){
        return exerciseRepository.orderByName();
    }
}
