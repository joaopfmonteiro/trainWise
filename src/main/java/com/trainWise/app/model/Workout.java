package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date day;

    @ManyToOne
    private MesoCicle mesoCicle;
//
//    @ManyToOne
//    private Trainer trainer;
//
//    @ManyToOne
//    private Client client;
//
    @ManyToOne
    @JoinColumn(name = "self_trainer_id")
    private SelfTrainer selfTrainer;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TrainingUnit> trainingUnit;

    public Workout(Date day) {
        this.day = day;
    }
}
