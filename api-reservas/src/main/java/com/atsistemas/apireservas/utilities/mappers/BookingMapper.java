package com.atsistemas.apireservas.utilities.mappers;

import com.atsistemas.apireservas.dtos.BookingDto;
import com.atsistemas.apireservas.dtos.HotelDto;
import com.atsistemas.apireservas.entities.Booking;
import com.atsistemas.apireservas.entities.Hotel;
import org.modelmapper.ModelMapper;

public class BookingMapper {

    static ModelMapper modelMapper = new ModelMapper();

    public static Booking convertToEntity (BookingDto bookingDto){
        return modelMapper.map(bookingDto, Booking.class);
    }

    public static BookingDto convertToDto (Booking booking){
        return modelMapper.map(booking, BookingDto.class);
    }
}
