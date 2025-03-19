package com.trainWise.app.service;

import com.trainWise.app.model.MesoCicle;
import com.trainWise.app.repository.MesoCicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesoCicleService {

    @Autowired
    MesoCicleRepository mesoCicleRepository;

    public MesoCicle getById(Long id){
        return mesoCicleRepository.getById(id);
    }

    public MesoCicle createMesoCicle(MesoCicle mesoCicle){
        return mesoCicleRepository.save(mesoCicle);
    }

    public void updateMesoCicle(MesoCicle mesoCicle){
        mesoCicleRepository.save(mesoCicle);
    }
}
