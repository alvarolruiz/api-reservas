package com.atsistemas.apireservas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
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
