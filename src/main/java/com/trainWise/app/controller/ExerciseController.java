package com.trainWise.app.controller;

import com.trainWise.app.model.Exercise;
import com.trainWise.app.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
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

    @PostMapping("/create")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise){
        Exercise newExercise = exerciseService.createExercise(exercise);
        return ResponseEntity.ok(newExercise);
    }

    @PutMapping("/{id}")
    public void updateExercise(@RequestBody Exercise exercise, @PathVariable Long id){
        exerciseService.update(exercise);
    }
}
