package com.trainWise.app.controller;

import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.service.TrainingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainingUnit")
public class TrainingUnitController {

    @Autowired
    TrainingUnitService trainingUnitService;

    @GetMapping()
    public List<TrainingUnit> getAll(){
        return trainingUnitService.getAll();
    }

    @PostMapping()
    public ResponseEntity<TrainingUnit> createTrainingUnit(@RequestBody TrainingUnit trainingUnit){
        TrainingUnit newTrainingUnit = trainingUnitService.createTrainingUnit(trainingUnit);
        return ResponseEntity.ok(newTrainingUnit);
    }

    @PutMapping("/{id}")
    public void updateTrainingUnit(@RequestBody TrainingUnit trainingUnit, @PathVariable Long id){
        trainingUnitService.updateTrainingUnit(trainingUnit);
    }

    @PutMapping("/{trainingUnitId}/{exerciseId}")
    public  ResponseEntity<TrainingUnit> addExerciseToTraining(
            @PathVariable Long trainingUnitId,
            @PathVariable Long exerciseId){
        TrainingUnit updateTrainingUnit = trainingUnitService.addExerciseToTrainingUnit(trainingUnitId, exerciseId);
        return ResponseEntity.ok(updateTrainingUnit);
    }

    @GetMapping("workoutId/{workoutId}")
    public ResponseEntity<List<TrainingUnit>> getTrainingUnitId(@PathVariable Long workoutId){
        List<TrainingUnit> trainingUnits = trainingUnitService.getTrainingUnitsByWorkout(workoutId);
        return ResponseEntity.ok(trainingUnits);
    }
}
