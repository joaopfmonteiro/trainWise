package com.trainWise.app.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainWise.app.model.SelfTrainer;
import com.trainWise.app.security.JwtService;
import com.trainWise.app.service.SelfTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/self_trainer")
public class SelfTrainerController {

    @Autowired
    SelfTrainerService selfTrainerService;

    @GetMapping("/{id}")
    public SelfTrainer getById(@PathVariable Long id){
        return selfTrainerService.getById(id);
    }

    @PostMapping("create")
    public SelfTrainer create(@RequestBody SelfTrainer selfTrainer){
        return selfTrainerService.create(selfTrainer);
    }

    @PutMapping("/{id}")
    public SelfTrainer update(@RequestBody SelfTrainer selfTrainer, @PathVariable long id){
        return selfTrainerService.update(selfTrainer);
    }

    @GetMapping("/me")
    public ResponseEntity<SelfTrainer> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();

        SelfTrainer user = selfTrainerService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return ResponseEntity.ok(user);
    }

}
