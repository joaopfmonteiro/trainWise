package com.trainWise.app.service;

import com.trainWise.app.model.SelfTrainer;
import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.repository.SelfTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfTrainerService {

    @Autowired
    SelfTrainerRepository selfTrainerRepository;

    public SelfTrainer update(SelfTrainer selfTrainer){
        return selfTrainerRepository.save(selfTrainer);
    }

}
