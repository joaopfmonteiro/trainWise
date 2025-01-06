package com.trainWise.app.controller;

import com.trainWise.app.model.Workout;
import com.trainWise.app.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @PostMapping("/create")
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout){
        Workout newWorkout = workoutService.createWorkout(workout);
        return ResponseEntity.ok(workout);
    }

    @PutMapping("/{id}")
    public void updateWorkout(@RequestBody Workout workout, @PathVariable Long id){
        workoutService.updateWorkout(workout);
    }



}
