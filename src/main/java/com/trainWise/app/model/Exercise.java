package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trainWise.app.model.enums.ExerciseEquipment;
import com.trainWise.app.model.enums.ExerciseType;
import com.trainWise.app.model.enums.Muscle;
import com.trainWise.app.model.enums.MuscleGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @OneToOne
    @JoinColumn(name = "training_unit_id")
    @JsonIgnore
    private TrainingUnit trainingUnits;

    String name;

    String details;

    String img;

    String video;

    @ElementCollection(targetClass = Muscle.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "exercise_muscles", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "muscle")
    List<Muscle> muscle;

    @ElementCollection(targetClass = MuscleGroup.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "exercise_muscle_groups", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "muscle_group")
    List<MuscleGroup> muscleGroup;

    @ElementCollection(targetClass = ExerciseType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "exercise_type", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "exercise_type")
    List<ExerciseType> exerciseType;

    @Enumerated(EnumType.STRING)
    @Column(name = "equipment")
    private ExerciseEquipment equipment;

    public Exercise(String name, List<Muscle> muscle, List<MuscleGroup> muscleGroup,
                    List<ExerciseType> exerciseType, ExerciseEquipment equipment,
                    String details, String img, String video) {
        this.name = name;
        this.muscle = muscle;
        this.muscleGroup = muscleGroup;
        this.exerciseType = exerciseType;
        this.equipment = equipment;
        this.details = details;
        this.img = img;
        this.video = video;
    }

}
