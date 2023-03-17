package com.atsistemas.apireservas.services;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingsService {
    Book bookRoom(Integer idHotel, LocalDate dateFrom, LocalDate dateTo, String email);

    List<Book> findBooksForHotelBetweenDates(Integer idHotel, LocalDate dateFrom, LocalDate dateTo);

    Optional<Book> findBookById (Integer bookId);

    boolean cancelBook (Integer bookId);
}
