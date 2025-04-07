package com.trainWise.app.controller;

import com.trainWise.app.dto.CurrentWorkoutDto;
import com.trainWise.app.dto.WorkoutDto;
import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.model.Workout;
import com.trainWise.app.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @PostMapping()
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout){
        Workout newWorkout = workoutService.createWorkout(workout);
        return ResponseEntity.ok(newWorkout);
    }

    @PutMapping("/{id}")
    public void updateWorkout(@RequestBody Workout workout, @PathVariable Long id){
        workoutService.updateWorkout(workout);
    }

    @PostMapping("/{workoutId}/training-unit/{trainingId}")
    public ResponseEntity<String> addTrainingUnitToWorkout(
            @PathVariable Long workoutId,
            @PathVariable Long trainingId) {
        workoutService.addTrainingUnitToWorkout(workoutId, trainingId);
        return ResponseEntity.ok("TrainingUnit " + trainingId + " linked to Workout " + workoutId);
    }

    @PostMapping("/{workoutId}/user/{userId}")
    public ResponseEntity<String> addWorkoutToUser(
            @PathVariable Long userId,
            @PathVariable Long workoutId) {
        workoutService.addWorkoutToUser(workoutId, userId);
        return ResponseEntity.ok("Workout have ben added");
    }

    @GetMapping("/{workoutId}")
    public ResponseEntity<List<WorkoutDto>> findTrainingUnitsByWorkout(@PathVariable Long workoutId){
        List<WorkoutDto> trainingUnits = workoutService.getTrainingUnitsByWorkout(workoutId);
        return ResponseEntity.ok(trainingUnits);
    }

    @GetMapping("/current-workout/{userId}")
    public ResponseEntity<List<CurrentWorkoutDto>> findFirstWorkoutByDayAndUser(@PathVariable Long userId){
        List<CurrentWorkoutDto> workout = workoutService.findFirstWorkoutByDayAndUser(userId);
        return ResponseEntity.ok(workout);
    }
}
