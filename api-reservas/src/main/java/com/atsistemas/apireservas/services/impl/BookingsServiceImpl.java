package com.atsistemas.apireservas.services.impl;

import com.atsistemas.apireservas.entities.Booking;
import com.atsistemas.apireservas.repositories.BookingsRepository;
import com.atsistemas.apireservas.services.AvailabilitiesService;
import com.atsistemas.apireservas.services.BookingsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingsServiceImpl implements BookingsService {

    private BookingsRepository repository;
    private AvailabilitiesService availabilitiesService;

    public BookingsServiceImpl(BookingsRepository repository, AvailabilitiesService availabilitiesService) {
        this.repository = repository;
        this.availabilitiesService = availabilitiesService;
    }

    @Override
    public void saveBooking(Booking booking) {
        availabilitiesService.reduceAvailability(booking.getIdHotel(),booking.getDateFrom(), booking.getDateTo());
        repository.save(booking);
    }

    @Override
    public List<Booking> findBookingsForHotelBetweenDates(Integer idHotel, LocalDate dateFrom, LocalDate dateTo) {
        return repository.findBookingssForHotelBetweenDates(idHotel, dateFrom, dateTo);
    }

    @Override
    public Optional<Booking> findBookingById(Integer bookId) {
        return repository.findById(bookId);
    }

    @Override
    public void cancelBook(Integer bookId) {
        //Cuando se cancela se abre la disponibilidad de nuevo, pero en que momento se ha actualizado, y es
        //necesario poner el numero de habitaciones a reservar. Asumo que es una
        repository.deleteById(bookId);
    }
}
