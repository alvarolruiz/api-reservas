package com.atsistemas.apireservas.services.impl;

import com.atsistemas.apireservas.models.Availability;
import com.atsistemas.apireservas.models.Hotel;
import com.atsistemas.apireservas.repository.AvailabilitiesRepository;
import com.atsistemas.apireservas.services.AvailabilitiesService;
import com.atsistemas.apireservas.utilities.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvailabilitiesServiceImpl implements AvailabilitiesService {

    private AvailabilitiesRepository repository;

    public AvailabilitiesServiceImpl(AvailabilitiesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void openAvailability(Integer idHotel, Integer nHabitaciones, LocalDate dateFrom, LocalDate dateTo) {
        List<LocalDate> datesRange = DateUtils.getDatesBetweenTwoDates(dateFrom, dateTo);
        List<Availability> availabilitiesList = datesRange.stream()
                .map(date -> repository.findAvailabilityForDate(date)
                .orElseGet(() -> new Availability(date, idHotel)))
                .collect(Collectors.toList());
        availabilitiesList.forEach(availability -> {
            availability.setRooms(availability.getRooms() + nHabitaciones);
        });
        repository.saveAll(availabilitiesList);
    }

    @Override
    public List<Hotel> consultAvailability(LocalDate dateFrom, LocalDate dateTo) {
        return null;
    }


}
