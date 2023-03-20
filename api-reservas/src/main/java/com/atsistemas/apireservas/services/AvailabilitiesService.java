package com.atsistemas.apireservas.services;

import com.atsistemas.apireservas.models.Availability;
import com.atsistemas.apireservas.models.Hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilitiesService {
    void openAvailability(Integer idHotel, Integer nHabitaciones, LocalDate dateFrom, LocalDate dateTo);

    //Filtro con los campos por los que se puede filtrar la disponibilidad?
    List<Hotel> consultAvailability(LocalDate dateFrom, LocalDate dateTo);



}
