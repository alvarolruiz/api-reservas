package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.dtos.AvailabilityDto;
import com.atsistemas.apireservas.entities.Availability;
import com.atsistemas.apireservas.services.AvailabilitiesService;
import com.atsistemas.apireservas.utilities.DateUtils;
import com.atsistemas.apireservas.utilities.filters.AvailabilitiesFilter;
import com.atsistemas.apireservas.utilities.mappers.AvailabilitiesMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("availabilities")
public class AvailabilityController {

    private AvailabilitiesService availabilitiesService;

    public AvailabilityController(AvailabilitiesService availabilitiesService) {
        this.availabilitiesService = availabilitiesService;
    }

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity openAvailabilities(@RequestParam Integer idHotel, @RequestParam Integer nRooms,
                                             @Valid @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
                                             @Valid @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo) {
        availabilitiesService.openAvailability(idHotel, nRooms, dateFrom, dateTo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity searchAvailabilities(@RequestParam @Valid AvailabilitiesFilter availabilitiesFilter) {
        List<Availability> availabilitiesList = availabilitiesService.consultAvailability(availabilitiesFilter);
        List<AvailabilityDto> availabilitiesDtoList = AvailabilitiesMapper.convertEntityListToDtoList(availabilitiesList);
        return ResponseEntity.ok(availabilitiesDtoList);

    }

}
