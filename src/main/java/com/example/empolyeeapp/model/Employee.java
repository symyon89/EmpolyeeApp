package com.example.empolyeeapp.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Setter
@Getter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String email;

    @Column(length = 40)
    private String department;
}
