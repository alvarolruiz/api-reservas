package com.atsistemas.apireservas.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "availabilities")
public class Availability {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "availability_date")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;
    @Column(name = "rooms")
    private Integer rooms;
}
