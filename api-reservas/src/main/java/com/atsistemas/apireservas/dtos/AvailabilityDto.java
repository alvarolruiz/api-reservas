package com.atsistemas.apireservas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class AvailabilityDto {
    private Integer id;
    private LocalDate date;
    private Integer rooms;
}
