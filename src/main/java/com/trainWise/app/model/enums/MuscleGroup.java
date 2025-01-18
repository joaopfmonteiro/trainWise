package com.trainWise.app.model.enums;

import lombok.Getter;

@Getter
public enum MuscleGroup {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    ARMS("Arms"),
    CORE("Core"),
    LEGS("Legs");

    private final String muscleGroup;

    MuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

}
