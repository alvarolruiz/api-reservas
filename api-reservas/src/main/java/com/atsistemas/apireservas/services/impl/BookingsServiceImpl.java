package com.atsistemas.apireservas.services.impl;

import com.atsistemas.apireservas.repositories.BookingsRepository;
import com.atsistemas.apireservas.services.BookingsService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingsServiceImpl implements BookingsService {

    private BookingsRepository repository;

    public BookingsServiceImpl(BookingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book bookRoom(Integer idHotel, LocalDate dateFrom, LocalDate dateTo, String email) {
        return null;
    }

    @Override
    public List<Book> findBooksForHotelBetweenDates(Integer idHotel, LocalDate dateFrom, LocalDate dateTo) {
        return null;
    }

    @Override
    public Optional<Book> findBookById(Integer bookId) {
        return Optional.empty();
    }

    @Override
    public boolean cancelBook(Integer bookId) {
        return false;
    }
}
