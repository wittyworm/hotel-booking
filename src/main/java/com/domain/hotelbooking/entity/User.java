package com.domain.hotelbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// using getter and setter from lombok for brevity,
// so as to avoid boilerplate of getter and setter
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
