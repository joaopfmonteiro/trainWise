package com.trainWise.app.service;

import com.trainWise.app.model.Trainer;
import com.trainWise.app.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public Trainer update(Trainer trainer){
        return trainerRepository.save(trainer);
    }
}
