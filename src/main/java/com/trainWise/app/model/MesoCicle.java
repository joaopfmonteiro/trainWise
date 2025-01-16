package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MesoCicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String mesoCicleName;

//    @OneToMany(mappedBy = "mesoCicle", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Workout> workouts;

    private Date startDate;

    private Date endDate;

//    @ManyToOne
//    @JoinColumn(name = "client_id", nullable = false)
//    private Client client;
//
//    @ManyToOne
//    @JoinColumn(name = "tainer_id", nullable = false)
//    private Trainer trainer;
//
//    @ManyToOne
//    @JoinColumn(name = "self_trainer_id", nullable = false)
//    private SelfTrainer selfTrainer;
}

