package com.trainWise.app.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String name;

    private String email;

    private String password;

    private Date birthDate;

    private double height;

    private double weight;

}
