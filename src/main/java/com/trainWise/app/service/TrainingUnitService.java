package com.trainWise.app.service;

import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.repository.TrainerRepository;
import com.trainWise.app.repository.TrainingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingUnitService {

    @Autowired
    TrainingUnitRepository trainingUnitRepository;

    public List<TrainingUnit> getAll(){
        return trainingUnitRepository.findAll();
    }

    public TrainingUnit createTrainingUnit(TrainingUnit trainingUnit){
        return trainingUnitRepository.save(trainingUnit);
    }

    public void updateTrainingUnit(TrainingUnit trainingUnit){
         trainingUnitRepository.save(trainingUnit);
    }
}
