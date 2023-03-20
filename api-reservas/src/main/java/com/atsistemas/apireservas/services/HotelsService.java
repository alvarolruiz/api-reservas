package com.atsistemas.apireservas.services;

import com.atsistemas.apireservas.models.Hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HotelsService {
    void createHotel(Hotel hotel);

    void updateHotel(Integer idHotel, Hotel hotel);

    Optional<Hotel> findHotelById(Integer idHotel);

    List<Hotel> findAllHotels();




}
