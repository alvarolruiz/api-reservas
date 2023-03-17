package com.atsistemas.apireservas.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "hoteles")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private Integer category;
}
