package com.trainWise.app.service;

import com.trainWise.app.model.SelfTrainer;
import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.repository.SelfTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SelfTrainerService {

    @Autowired
    SelfTrainerRepository selfTrainerRepository;

    public SelfTrainer getById(Long id){
        return selfTrainerRepository.getById(id);
    }

    public SelfTrainer create(SelfTrainer selfTrainer){
        return selfTrainerRepository.save(selfTrainer);
    }

    public SelfTrainer update(SelfTrainer selfTrainer){
        return selfTrainerRepository.save(selfTrainer);
    }
    public Optional<SelfTrainer> findByEmail(String email) {
        return selfTrainerRepository.findByEmail(email);
    }

}
