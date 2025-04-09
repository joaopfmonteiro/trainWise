package com.trainWise.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class NutritionProgressDto {

    private double height;

    private double weight;

    private String gender;

    private Date birthDate;

    private int physicalActivity;

    private int tmbValue;

    public NutritionProgressDto(double height, double weight, String gender, Date birthDate) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
