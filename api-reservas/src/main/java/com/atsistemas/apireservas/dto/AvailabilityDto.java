package com.atsistemas.apireservas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
@AllArgsConstructor
public class AvailabilityDto {
    private Integer id;
    private LocalDate date;
    private Integer rooms;
}
