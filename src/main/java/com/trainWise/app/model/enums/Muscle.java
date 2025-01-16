package com.trainWise.app.model.enums;

import lombok.Getter;

@Getter
public enum Muscle {


    CHEST(MuscleGroup.CHEST, "Chest"),
    UPPER_CHEST(MuscleGroup.CHEST, "Upper Chest"),
    LOWER_CHEST(MuscleGroup.CHEST, "Lower Chest"),

    UPPER_BACK(MuscleGroup.BACK, "Upper Back"),
    LOWER_BACK(MuscleGroup.BACK, "Lower Back"),
    LATS(MuscleGroup.BACK, "Lats"),
    TRAPS(MuscleGroup.BACK, "Traps"),

    FRONT_DELTS(MuscleGroup.SHOULDERS, "Front Delts"),
    SIDE_DELTS(MuscleGroup.SHOULDERS, "Side Delts"),
    REAR_DELTS(MuscleGroup.SHOULDERS, "Rear Delts"),
    ROTATOR_CUFF(MuscleGroup.SHOULDERS, "Rotator Cuff"),

    BICEPS(MuscleGroup.ARMS, "Biceps"),
    TRICEPS(MuscleGroup.ARMS, "Triceps"),
    FOREARMS(MuscleGroup.ARMS, "Forearms"),

    ABS(MuscleGroup.CORE, "Abs"),
    OBLIQUES(MuscleGroup.CORE, "Obliques"),

    QUADS(MuscleGroup.LEGS, "Quads"),
    HAMSTRINGS(MuscleGroup.LEGS, "Hamstrings"),
    GLUTES(MuscleGroup.LEGS, "Glutes"),
    GLUTE_MAX(MuscleGroup.LEGS, "Glute Max (Posterior Glute)"),
    GLUTE_MED_MIN(MuscleGroup.LEGS, "Glute Med & Min (Abductor)"),
    CALVES(MuscleGroup.LEGS, "Calves"),
    ADDUCTORS(MuscleGroup.LEGS, "Adductors");

    private final MuscleGroup muscleGroup;
    private final String muscle;

    Muscle(MuscleGroup muscleGroup, String muscle){
        this.muscleGroup = muscleGroup;
        this.muscle = muscle;
    }

}
