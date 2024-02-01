package com.domain.hotelbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// using getter and setter from lombok for brevity,
// so as to avoid boilerplate of getter and setter
@Getter
@Setter
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "website")
    private String website;

}
