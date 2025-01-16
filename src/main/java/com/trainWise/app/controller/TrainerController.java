package com.trainWise.app.controller;

import com.trainWise.app.model.Trainer;
import com.trainWise.app.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PutMapping("/{id}")
    public Trainer update(@RequestBody Trainer trainer, @PathVariable long id){
        return trainerService.update(trainer);
    }
}
