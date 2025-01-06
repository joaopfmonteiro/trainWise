package com.trainWise.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Client extends User{

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany
    private List<MesoCicle> mesoCicle;

    @OneToMany
    private List<Workout> worokoutsList;
}
