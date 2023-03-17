package com.atsistemas.apireservas.services.impl;

import com.atsistemas.apireservas.models.Hotel;
import com.atsistemas.apireservas.repository.AvailabilitiesRepository;
import com.atsistemas.apireservas.services.AvailabilitiesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilitiesServiceImpl implements AvailabilitiesService {

    private AvailabilitiesRepository repository;
    @Override
    public void openAvailability(Integer idHotel, Integer nHabitaciones, LocalDate dateFrom, LocalDate dateTo) {

    }

    @Override
    public List<Hotel> consultAvailability(LocalDate dateFrom, LocalDate dateTo) {
        return null;
    }
}
