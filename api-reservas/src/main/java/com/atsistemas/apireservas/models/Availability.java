package com.atsistemas.apireservas.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "availabilities")
public class Availability {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "availability_date")
    private LocalDate date;
    @Column(name = "idHotel")
    private Integer idHotel;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;
    @Column(name = "rooms")
    private Integer rooms;

    public Availability(LocalDate date, Integer idHotel) {
        this.rooms = 0;
        this.date = date;
        this.idHotel = idHotel;
    }
}
