package com.trainWise.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date day;

    @ManyToOne
    @JoinColumn(name = "meso_cicle_id")
    private MesoCicle mesoCicle;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "self_trainer_id")
    private SelfTrainer selfTrainer;

    @OneToMany
    private List<TrainingUnit> trainingUnit;
}
