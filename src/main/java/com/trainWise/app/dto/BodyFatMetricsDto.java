package com.trainWise.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BodyFatMetricsDto {

    private double neck;
    private double waist;
    private double hip;
    private double height;
    private String gender;
    private String fatClassification;
    private double fatPercent;
    private Date birthDate;

    public BodyFatMetricsDto(double neck, double waist, double hip, double height, String gender, Date birthDate) {
        this.neck = neck;
        this.waist = waist;
        this.hip = hip;
        this.height = height;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
