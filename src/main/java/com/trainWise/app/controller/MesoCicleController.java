package com.trainWise.app.controller;

import com.trainWise.app.model.MesoCicle;
import com.trainWise.app.service.MesoCicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meso")
public class MesoCicleController {

    @Autowired
    MesoCicleService mesoCicleService;

    @PostMapping()
    public ResponseEntity<MesoCicle> createMesoCicle(@RequestBody MesoCicle mesoCicle){
        MesoCicle newMesocicle = mesoCicleService.createMesoCicle(mesoCicle);
        return ResponseEntity.ok(mesoCicle);
    }

    @PutMapping("/{id}")
    public void updateMesocicle(@RequestBody MesoCicle mesoCicle, @PathVariable Long id){
        mesoCicleService.updateMesoCicle(mesoCicle);
    }
}
