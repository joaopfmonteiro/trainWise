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

    private final String muscleGrup;

    MuscleGroup(String muscleGrup) {
        this.muscleGrup = muscleGrup;
    }

}
