package com.trainWise.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TrainingUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "meso_cicle_id")
    private MesoCicle mesoCicle;

    @OneToMany
    private List<Exercise> exercise;

    private int reps;

    private int set;

    private double weight;
}
