package com.trainWise.app.controller;

import com.trainWise.app.dto.ExerciseNameDto;
import com.trainWise.app.model.Exercise;
import com.trainWise.app.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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

    @GetMapping("/filter")
    public ResponseEntity<List<Exercise>> filterExercisesByEquipment(@RequestParam MultiValueMap<String, String> params) {
        List<String> equipments = params.get("equipments");
        List<Exercise> listEquipments = exerciseService.getExercisesByEquipment(equipments);
        return ResponseEntity.ok(listEquipments);
    }

    @GetMapping("/filterByType")
    public ResponseEntity<List<Exercise>> filterExercisesByType(@RequestParam MultiValueMap<String, String> exerciseTypes) {
        List<String> getExerciseTypes = exerciseTypes.get("exerciseType");
        List<Exercise> listExerciseTypes = exerciseService.getExercisesByExerciseType(getExerciseTypes);
        return ResponseEntity.ok(listExerciseTypes);
    }

    @GetMapping("/filterByMuscle")
    public ResponseEntity<List<Exercise>> filterExercisesByExerciseMuscle(@RequestParam MultiValueMap<String, String> muscle) {
        List<String> getMuscles = muscle.get("muscle");
        List<Exercise> listOfMuscles = exerciseService.getExercisesByExerciseMuscle(getMuscles);
        return ResponseEntity.ok(listOfMuscles);
    }

    @GetMapping("/filterByMuscleGroup")
    public ResponseEntity<List<Exercise>> filterExercisesByExerciseMuscleGroup(@RequestParam MultiValueMap<String, String> muscleGroup) {
        List<String> getMusclesGroup = muscleGroup.get("muscle_group");
        List<Exercise> listOfMuscles = exerciseService.getExercisesByExerciseMuscleGroup(getMusclesGroup);
        return ResponseEntity.ok(listOfMuscles);
    }

}
