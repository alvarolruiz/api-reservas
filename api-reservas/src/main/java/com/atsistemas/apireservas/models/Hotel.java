package com.atsistemas.apireservas.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private Integer category;
}
