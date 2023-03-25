package com.atsistemas.apireservas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_hotel")
    private Integer idHotel;
    @Column(name = "date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;
    @Column(name = "email")
    private String email;

    public Booking(Integer idHotel, LocalDate dateFrom, LocalDate dateTo, String email) {
        this.idHotel = idHotel;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.email = email;
    }
}
