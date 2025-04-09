package com.trainWise.app.model;

import com.trainWise.app.model.enums.Goals;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "The mane is required")
    private String name;

    @NotNull(message = "The email is required")
    @Email(message = "The email is already registered")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "The password is required")
    private String password;

    private Date birthDate;

    @NotNull
    private String userName;

    private double height;

    private double weight;

    private double goalWeight;

    private String gender;

    private double neck;

    private double waist;

    private double hip;

    private int physicalActivity;

    @Enumerated(EnumType.STRING)
    @Column(name = "goals")
    private Goals goals;
}
