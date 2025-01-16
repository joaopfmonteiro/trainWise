package com.trainWise.app.model.enums;

import lombok.Getter;

@Getter
public enum ExerciseType {

    STRENGTH("Strength"),


    CARDIO("Cardio"),
    METABOLIC("Metabolic"),

    FLEXIBILITY("Flexibility"),
    MOBILITY("Mobility"),

    SPEED("Speed"),
    AGILITY("Agility"),

    ENDURANCE("Endurance"),
    BALANCE("Balance"),

    FUNCTIONAL("Functional"),

    CALISTHENICS("Calisthenics"),
    GYMNASTIC_STRENGTH("Gymnastic Strength"),

    CROSSFIT("CrossFit"),
    HIGH_INTENSITY("High-Intensity"),

    COMBAT_SPORTS("Combat Sports");

    private final String name;

    ExerciseType(String name){
        this.name = name;
    }
}
