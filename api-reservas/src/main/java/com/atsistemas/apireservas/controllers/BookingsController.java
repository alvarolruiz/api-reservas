package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.repositories.BookingsRepository;
import com.atsistemas.apireservas.utilities.filters.BookingsFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("bookings")
public class BookingsController {

    private BookingsRepository bookingsRepository;

    public BookingsController(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    @GetMapping
    public ResponseEntity searchBookings(@Valid BookingsFilter bookingsFilter) {
        System.out.println(bookingsFilter.toString());
        return ResponseEntity.ok(null);
    }
}
