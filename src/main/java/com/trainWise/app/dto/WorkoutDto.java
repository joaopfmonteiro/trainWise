package com.trainWise.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class WorkoutDto {

    private int reps;

    private int set;

    private double weight;

    private Date day;

    private String name;

}
