package com.trainWise.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BmiDto {

    private double height;
    private double weight;
    private String gender;
    private String imcClassification;
    private double bmi;

    public BmiDto(double height, double weight, String gender) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }
}
