package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

//    @ManyToOne
//    private MesoCicle mesoCicle;
//
//    @ManyToOne
//    private Trainer trainer;
//
//    @ManyToOne
//    private Client client;
//
//    @ManyToOne
//    private SelfTrainer selfTrainer;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TrainingUnit> trainingUnit;
}
