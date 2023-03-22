package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.services.AvailabilitiesService;
import com.atsistemas.apireservas.utilities.DateUtils;
import com.atsistemas.apireservas.utilities.filters.AvailabilitiesFilter;
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

@RestController
@RequestMapping("availabilities")
public class AvailabilityController {

    private AvailabilitiesService availabilitiesService;

    public AvailabilityController(AvailabilitiesService availabilitiesService) {
        this.availabilitiesService = availabilitiesService;
    }

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity openAvailabilities(@RequestParam Integer idHotel, @RequestParam Integer nRooms,
                                             @RequestParam @NotEmpty @Valid String dateFrom,
                                             @RequestParam @NotEmpty @Valid String dateTo) {
        LocalDate localDateFrom = DateUtils.getLocalDateFromString(dateFrom);
        LocalDate localDateTo = DateUtils.getLocalDateFromString(dateTo);
        availabilitiesService.openAvailability(idHotel, nRooms, localDateFrom, localDateTo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity searchAvailabilities(@RequestParam @Valid AvailabilitiesFilter availabilitiesFilter) {
        return ResponseEntity.ok(availabilitiesService.consultAvailability(availabilitiesFilter));

    }

}
