package com.trainWise.app.model.enums;

import lombok.Getter;

@Getter
public enum Goals {

    LOSEWEIGHT("Lose weight"),
    MAINTEINWEIGHT("Maintain weight"),
    GAINWEIGHT("Gain weight"),
    GAINMUSCLE("Gain muscle"),
    IMPROVEFLEXIBILITY("Increase flexibility"),
    IMPROVEENDURANCE("Improve endurance");

    private final String name;
    Goals(String name){
        this.name = name;
    }
}
