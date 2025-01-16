package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class TrainingUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "meso_cicle_id")
//    private MesoCicle mesoCicle;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @OneToOne
    private Exercise exercise;

    private int reps;

    private int set;

    private double weight;
}
