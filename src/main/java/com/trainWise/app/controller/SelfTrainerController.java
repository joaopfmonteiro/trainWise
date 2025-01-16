package com.trainWise.app.controller;

import com.trainWise.app.model.SelfTrainer;
import com.trainWise.app.service.SelfTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/self_trainer")
public class SelfTrainerController {

    @Autowired
    SelfTrainerService selfTrainerService;

    @PutMapping("/{id}")
    public SelfTrainer update(@RequestBody SelfTrainer selfTrainer, @PathVariable long id){
        return selfTrainerService.update(selfTrainer);
    }

}
