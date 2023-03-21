package com.atsistemas.apireservas.utilities.mappers;

import com.atsistemas.apireservas.dtos.AvailabilityDto;
import com.atsistemas.apireservas.dtos.BookingDto;
import com.atsistemas.apireservas.entities.Availability;
import com.atsistemas.apireservas.entities.Booking;
import org.modelmapper.ModelMapper;

public class AvailabilitiesMapper {
    static ModelMapper modelMapper = new ModelMapper();

    public static Availability convertToEntity (AvailabilityDto availabilityDto){
        return modelMapper.map(availabilityDto, Availability.class);
    }

    public static AvailabilityDto convertToDto (Availability availability){
        return modelMapper.map(availability, AvailabilityDto.class);
    }
}
