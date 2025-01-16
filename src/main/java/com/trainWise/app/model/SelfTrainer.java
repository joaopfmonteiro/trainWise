package com.trainWise.app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SelfTrainer extends User{

//    @OneToMany
//    private List<MesoCicle> mesoCicle;
//
//    @OneToMany
//    private List<Workout> worokoutsList;

}
