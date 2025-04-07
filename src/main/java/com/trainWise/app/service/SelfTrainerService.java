package com.trainWise.app.service;

import com.trainWise.app.dto.BmiDto;
import com.trainWise.app.model.SelfTrainer;
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

    public BmiDto getBmi(Long id) {
        BmiDto bmiDto = selfTrainerRepository.getPersonalInfoForBmi(id);
        double bmi = calculate(bmiDto.getWeight(), bmiDto.getHeight());
        String classification = classifyBMI(bmi, bmiDto.getGender());
        bmiDto.setImcClassification(classification);
        bmiDto.setBmi(bmi);
        return bmiDto;
    }

    public double calculate(double weight, double height){
        return weight/ (height * height);
    }

    public String classifyBMI(double imc, String gender){

        String classifyBMI = "";
        if(gender ==  "Female"){
            if(imc < 19.0){
                return classifyBMI ="Underweight";
            }if(imc >= 19.0 && imc < 24){
                return classifyBMI = "Normal weight";
            }if(imc >= 24 && imc < 29){
                return classifyBMI = "Overweight";
            }if(imc >= 29 && imc < 39){
                return classifyBMI = "Obesity";
            }if(imc >= 39){
                return classifyBMI = "Severe obesity";
            }
        }
        if(gender.equals("Male")){
            if(imc < 20.0){
                return classifyBMI = "Underweight";
            }if(imc >= 20.0 && imc < 25){
                return classifyBMI = "Normal weight";
            }if(imc >= 25 && imc < 30){
                return classifyBMI ="Overweight";
            }if(imc >= 30 && imc < 40){
                return classifyBMI ="Obesity";
            }if(imc >= 40){
                return classifyBMI ="Severe obesity";
            }
        }
        return classifyBMI;
    }
}
