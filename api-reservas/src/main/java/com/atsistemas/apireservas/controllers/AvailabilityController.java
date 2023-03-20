package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.models.Availability;
import com.atsistemas.apireservas.services.AvailabilitiesService;
import com.atsistemas.apireservas.utilities.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("availabilities")
public class AvailabilityController {

    private AvailabilitiesService availabilitiesService;

    public AvailabilityController(AvailabilitiesService availabilitiesService) {
        this.availabilitiesService = availabilitiesService;
    }
    @PostMapping
    public ResponseEntity openAvailabilities (@RequestParam Integer idHotel,@RequestParam Integer nRooms, @RequestParam String dateFrom, @RequestParam String dateTo){
        LocalDate localDateFrom = DateUtils.getLocalDateFromString(dateFrom);
        LocalDate localDateTo = DateUtils.getLocalDateFromString(dateTo);
        availabilitiesService.openAvailability(idHotel,nRooms, localDateFrom, localDateTo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
