package com.trainWise.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CurrentWorkoutDto {

    private String name;
    private String equipment;
    private int reps;
    private int set;
    private int weight;
    private Date day;
}
