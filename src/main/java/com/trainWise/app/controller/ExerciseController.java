package com.trainWise.app.controller;

import com.trainWise.app.dto.ExerciseMuscleDto;
import com.trainWise.app.dto.ExerciseNameDto;
import com.trainWise.app.model.Exercise;
import com.trainWise.app.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping()
    public List<Exercise> getAll(){
        return exerciseService.getAll();
    }

    @GetMapping("/search/name/{name}")
    public List<ExerciseNameDto> searchByName(@PathVariable String name){
        return exerciseService.searchByName(name);
    }

//    @GetMapping("/search/muscle/{muscle}")
//    public List<ExerciseMuscleDto> searchByMuscle(@PathVariable String muscle){
//        return exerciseService.searchByMuscle(muscle);
//    }

    @PostMapping()
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise){
        Exercise newExercise = exerciseService.createExercise(exercise);
        return ResponseEntity.ok(newExercise);
    }

    @PutMapping("/{id}")
    public void updateExercise(@RequestBody Exercise exercise, @PathVariable Long id){
        exerciseService.update(exercise);
    }

    @GetMapping("order-by-name")
    public ResponseEntity<List<ExerciseNameDto>> oderByName(){
        List<ExerciseNameDto> exerciseNameDto = exerciseService.orderByName();
        return ResponseEntity.ok(exerciseNameDto);
    }

//    @GetMapping("order-by-muscle")
//    public ResponseEntity<List<ExerciseMuscleDto>> orderByMuscle(){
//        List<ExerciseMuscleDto> exerciseMuscleDto = exerciseService.oderByMuscle();
//        return ResponseEntity.ok(exerciseMuscleDto);
//}

    }
