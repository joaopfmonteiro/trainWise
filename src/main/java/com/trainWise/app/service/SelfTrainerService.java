package com.trainWise.app.service;

import com.trainWise.app.dto.BmiDto;
import com.trainWise.app.dto.BodyFatMetricsDto;
import com.trainWise.app.model.SelfTrainer;
import com.trainWise.app.repository.SelfTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
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
        if(gender.equals("Female") ){
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

    public BodyFatMetricsDto getFodyFat(Long id){
        BodyFatMetricsDto bodyFatMetricsDto = selfTrainerRepository.getPersonalIfoForBodyFat(id);
        double bodyFatCalc = bodyFatCalc(bodyFatMetricsDto.getNeck(),
                bodyFatMetricsDto.getWaist(),
                bodyFatMetricsDto.getHip(),
                bodyFatMetricsDto.getHeight(),
                bodyFatMetricsDto.getGender());
        int currentAge = convertToAge(bodyFatMetricsDto.getBirthDate());
        String fatClassification = getFatClassification(bodyFatCalc, bodyFatMetricsDto.getGender(), currentAge);
        bodyFatMetricsDto.setFatClassification(fatClassification);
        bodyFatMetricsDto.setFatPercent(bodyFatCalc);
        return bodyFatMetricsDto;
    }

    public double bodyFatCalc(double neck, double waist, double hip, double height, String gender){

        double logWaistNeck = Math.log10(convertToInches(waist-neck));
        double logWaistHipNeck = Math.log10(convertToInches(waist + hip - neck));
        double logHeight = Math.log10(convertToInches(height * 100));
        double fatResult = 0;
        if(gender.equals("Male")){
            fatResult = 86.010 * logWaistNeck - 70.041 * logHeight + 36.76;
            return fatResult;
        }if (gender.equals("Female")){
            fatResult = 163.205 * logWaistHipNeck - 97.684 * logHeight - 78.387;
            return fatResult;
        }
        return fatResult;
    }

    public String getFatClassification(double fatResult, String gender, int age){
        String fatClassification = "";
        if(gender.equals("Male")){
            if(age >18 && age <= 30){
                if (fatResult > 6 && fatResult < 14){
                    fatClassification = "Excellent";
                }if (fatResult >= 14 && fatResult < 18){
                    fatClassification = "Good";
                }if (fatResult >= 18 && fatResult < 24){
                    fatClassification = "Average";
                }if (fatResult >= 24 && fatResult < 29){
                    fatClassification = "Below Average";
                }if (fatResult >= 29){
                    fatClassification = "Poor";
                }
            }if(age >30 && age <= 40){
                if (fatResult > 6 && fatResult < 15){
                    fatClassification = "Excellent";
                }if (fatResult >= 15 && fatResult < 19){
                    fatClassification = "Good";
                }if (fatResult >= 19 && fatResult < 25){
                    fatClassification = "Average";
                }if (fatResult >= 25 && fatResult < 30){
                    fatClassification = "Below Average";
                }if (fatResult >= 30){
                    fatClassification = "Poor";
                }
            }if(age >40 && age <= 50){
                if (fatResult > 7 && fatResult < 16){
                    fatClassification = "Excellent";
                }if (fatResult >= 16 && fatResult < 20){
                    fatClassification = "Good";
                }if (fatResult >= 20 && fatResult < 26){
                    fatClassification = "Average";
                }if (fatResult >= 26 && fatResult < 30){
                    fatClassification = "Below Average";
                }if (fatResult >= 30){
                    fatClassification = "Poor";
                }
            }if(age >50 && age <= 60){
                if (fatResult > 8 && fatResult < 17){
                    fatClassification = "Excellent";
                }if (fatResult >= 17 && fatResult < 21){
                    fatClassification = "Good";
                }if (fatResult >= 21 && fatResult < 26){
                    fatClassification = "Average";
                }if (fatResult >= 26 && fatResult < 32){
                    fatClassification = "Below Average";
                }if (fatResult >= 32){
                    fatClassification = "Poor";
                }
            }if(age >60 && age <= 70){
                if (fatResult > 9 && fatResult < 18){
                    fatClassification = "Excellent";
                }if (fatResult >= 18 && fatResult < 22){
                    fatClassification = "Good";
                }if (fatResult >= 22 && fatResult < 28){
                    fatClassification = "Average";
                }if (fatResult >= 28 && fatResult < 33){
                    fatClassification = "Below Average";
                }if (fatResult >= 33){
                    fatClassification = "Poor";
                }
            }if(age >70){
                if (fatResult > 10 && fatResult < 19){
                    fatClassification = "Excellent";
                }if (fatResult >= 19 && fatResult < 23){
                    fatClassification = "Good";
                }if (fatResult >= 23 && fatResult < 28){
                    fatClassification = "Average";
                }if (fatResult >= 28 && fatResult < 33){
                    fatClassification = "Below Average";
                }if (fatResult >= 33){
                    fatClassification = "Poor";
                }
            }
        }if(gender.equals("Female")){
            if(age >18 && age <= 30){
                if (fatResult > 14 && fatResult < 21){
                    fatClassification = "Excellent";
                }if (fatResult >= 21 && fatResult < 25){
                    fatClassification = "Good";
                }if (fatResult >= 25 && fatResult < 31){
                    fatClassification = "Average";
                }if (fatResult >= 31 && fatResult < 36){
                    fatClassification = "Below Average";
                }if (fatResult >= 36){
                    fatClassification = "Poor";
                }
            }if(age >30 && age <= 40){
                if (fatResult > 15 && fatResult < 22){
                    fatClassification = "Excellent";
                }if (fatResult >= 22 && fatResult < 26){
                    fatClassification = "Good";
                }if (fatResult >= 26 && fatResult < 32){
                    fatClassification = "Average";
                }if (fatResult >= 32 && fatResult < 37){
                    fatClassification = "Below Average";
                }if (fatResult >= 37){
                    fatClassification = "Poor";
                }
            }if(age >40 && age <= 50){
                if (fatResult > 16 && fatResult < 23){
                    fatClassification = "Excellent";
                }if (fatResult >= 23 && fatResult < 27){
                    fatClassification = "Good";
                }if (fatResult >= 27 && fatResult < 33){
                    fatClassification = "Average";
                }if (fatResult >= 33 && fatResult < 38){
                    fatClassification = "Below Average";
                }if (fatResult >= 38){
                    fatClassification = "Poor";
                }
            }if(age >50 && age <= 60){
                if (fatResult > 17 && fatResult < 24){
                    fatClassification = "Excellent";
                }if (fatResult >= 24 && fatResult < 28){
                    fatClassification = "Good";
                }if (fatResult >= 28 && fatResult < 34){
                    fatClassification = "Average";
                }if (fatResult >= 34 && fatResult < 39){
                    fatClassification = "Below Average";
                }if (fatResult >= 39){
                    fatClassification = "Poor";
                }
            }if(age >60 && age <= 70){
                if (fatResult > 18 && fatResult < 25){
                    fatClassification = "Excellent";
                }if (fatResult >= 25 && fatResult < 29){
                    fatClassification = "Good";
                }if (fatResult >= 29 && fatResult < 35){
                    fatClassification = "Average";
                }if (fatResult >= 35 && fatResult < 40){
                    fatClassification = "Below Average";
                }if (fatResult >= 40){
                    fatClassification = "Poor";
                }
            }if(age >70){
                if (fatResult > 19 && fatResult < 26){
                    fatClassification = "Excellent";
                }if (fatResult >= 26 && fatResult < 30){
                    fatClassification = "Good";
                }if (fatResult >= 30 && fatResult < 36){
                    fatClassification = "Average";
                }if (fatResult >= 36 && fatResult < 41){
                    fatClassification = "Below Average";
                }if (fatResult >= 41){
                    fatClassification = "Poor";
                }
            }
        }
        return fatClassification;
    }

    public int convertToAge(Date birthDate){
        LocalDate birthLocalDate = birthDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate today = LocalDate.now();

        return Period.between(birthLocalDate, today).getYears();
    }

    double convertToInches(double cm) {
        return cm / 2.54;
    }
}
