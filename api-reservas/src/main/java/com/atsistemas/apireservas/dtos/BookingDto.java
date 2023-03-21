package com.atsistemas.apireservas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingDto {

    private Integer id;
    private Integer idHotel;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String email;
}
