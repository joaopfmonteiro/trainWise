package com.trainWise.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

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

    private double height;

    private double weight;
}
