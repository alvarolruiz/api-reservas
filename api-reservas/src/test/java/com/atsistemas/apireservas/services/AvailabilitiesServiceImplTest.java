package com.atsistemas.apireservas.services;

import com.atsistemas.apireservas.entities.Availability;
import com.atsistemas.apireservas.repositories.AvailabilitiesRepository;
import com.atsistemas.apireservas.services.impl.AvailabilitiesServiceImpl;
import com.atsistemas.apireservas.utilities.DateUtils;
import com.atsistemas.apireservas.utilities.filters.AvailabilitiesFilter;
import com.atsistemas.apireservas.utilities.specifications.AvailabilitiesSpecifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AvailabilitiesServiceImplTest {
    private AvailabilitiesServiceImpl availabilitiesService;
    @Mock
    private AvailabilitiesRepository availabilitiesRepository;

    @BeforeEach
    public void initialize() {
        this.availabilitiesService = new AvailabilitiesServiceImpl(availabilitiesRepository);
    }

    @Test
    public void testConsultAvailabilities() {
        LocalDate dateFrom = DateUtils.getLocalDateFromString("20/03/2023");
        LocalDate dateTo = DateUtils.getLocalDateFromString("25/03/2023");
        AvailabilitiesFilter filter = new AvailabilitiesFilter();
        filter.setDateFrom(dateFrom);
        filter.setDateTo(dateTo);
        Specification<Availability> availabilitySpecification = AvailabilitiesSpecifications.getSpecification(filter);

        // Create a mock repository object
        AvailabilitiesRepository availabilitiesRepository = Mockito.mock(AvailabilitiesRepository.class);

        // Create a list of Availability objects to be returned by the mock repository
        List<Availability> availabilityList = List.of(
                new Availability(1, dateFrom, 1, 5),
                new Availability(2, dateFrom.plusDays(1), 1, 5),
                new Availability(3, dateFrom.plusDays(1), 1, 5),
                new Availability(4, dateFrom.plusDays(1), 1, 5),
                new Availability(5, dateFrom.plusDays(1), 1, 5)
        );

        // Stub the findAll method of the mock repository to return the availabilityList
        Mockito.when(availabilitiesRepository.findAll(Mockito.eq(availabilitySpecification))).thenReturn(availabilityList);

        // Create an instance of the AvailabilitiesServiceImpl class and set its repository field to the mock repository
        AvailabilitiesServiceImpl availabilitiesService = new AvailabilitiesServiceImpl(availabilitiesRepository);

        // Call the consultAvailability method with the filter object
        List<Availability> result = availabilitiesService.consultAvailability(filter);

        // Assert that the result matches the availabilityList returned by the mock repository
        Assertions.assertEquals(availabilityList, result);
    }
}
