package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.dtos.BookingDto;
import com.atsistemas.apireservas.services.BookingsService;
import com.atsistemas.apireservas.utilities.mappers.BookingMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("bookings")
public class BookingsController {

    private BookingsService bookingsService;

    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody @Valid BookingDto bookingDto) {
        bookingsService.saveBooking(BookingMapper.convertToEntity(bookingDto));
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity searchBookings(@RequestParam Integer idHotel,
                                         @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") @Valid LocalDate dateFrom,
                                         @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") @Valid LocalDate dateTo) {
        return ResponseEntity.ok(bookingsService.findBookingsForHotelBetweenDates(idHotel, dateFrom, dateTo));
    }


}
