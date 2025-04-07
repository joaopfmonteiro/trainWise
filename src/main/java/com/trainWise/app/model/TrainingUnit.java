package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @OneToOne
    private Exercise exercise;

    private int reps;

    private int set;

    private int weight;

    private int rest;

    public TrainingUnit(Exercise exercise, int reps, int set, int weight, int rest) {
        this.exercise = exercise;
        this.reps = reps;
        this.set = set;
        this.weight = weight;
        this.rest = rest;
    }
}
