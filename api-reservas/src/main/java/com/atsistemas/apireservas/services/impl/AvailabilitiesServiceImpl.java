package com.atsistemas.apireservas.services.impl;

import com.atsistemas.apireservas.controllers.Err.NoAvailabilityException;
import com.atsistemas.apireservas.controllers.Err.ResourceNotFoundException;
import com.atsistemas.apireservas.entities.Availability;
import com.atsistemas.apireservas.repositories.AvailabilitiesRepository;
import com.atsistemas.apireservas.services.AvailabilitiesService;
import com.atsistemas.apireservas.utilities.DateUtils;
import com.atsistemas.apireservas.utilities.filters.AvailabilitiesFilter;
import com.atsistemas.apireservas.utilities.specifications.AvailabilitiesSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
                .map(date -> repository.findAvailabilityForDateAndIdHotel(date, idHotel)
                .orElseGet(() -> new Availability(date, idHotel)))
                .collect(Collectors.toList());
        availabilitiesList.forEach(availability -> {
            availability.setRooms(availability.getRooms() + nHabitaciones);
        });
        repository.saveAll(availabilitiesList);
    }

    @Override
    public void reduceAvailability(Integer idHotel, LocalDate dateFrom, LocalDate dateTo) {
        List<LocalDate> datesRange = DateUtils.getDatesBetweenTwoDates(dateFrom, dateTo);
        List<Availability> availabilitiesList = datesRange.stream()
                        .map(date -> repository.findAvailabilityForDateAndIdHotel(date, idHotel)
                        .orElseThrow(() -> new NoAvailabilityException(date)))
                        .collect(Collectors.toList());
        availabilitiesList.forEach(availability -> {
            availability.setRooms(availability.getRooms() - 1);
        });
        repository.saveAll(availabilitiesList);
    }

    @Override
    public List<Availability> consultAvailability(AvailabilitiesFilter availabilitiesFilter) {
        List<LocalDate> datesRange = DateUtils.getDatesBetweenTwoDates(availabilitiesFilter.getDateFrom(), availabilitiesFilter.getDateTo());
        Specification<Availability> spec = AvailabilitiesSpecifications.getSpecification(availabilitiesFilter);
        List<Availability> availabilityList = repository.findAll(spec);
        boolean isAvailable = false;
        for (LocalDate d : datesRange) {
            isAvailable = availabilityList.stream().anyMatch(a -> a.getDate().equals(d) && a.getRooms().intValue() >= 1);
        }
        return isAvailable ? availabilityList : new ArrayList<>();
    }

    public void setRepository(AvailabilitiesRepository repository) {
        this.repository = repository;
    }
}
