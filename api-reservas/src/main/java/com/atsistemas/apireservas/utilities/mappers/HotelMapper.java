package com.atsistemas.apireservas.utilities.mappers;

import com.atsistemas.apireservas.dto.HotelDto;
import com.atsistemas.apireservas.models.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    static ModelMapper modelMapper = new ModelMapper();


    public static Hotel convertToEntity (HotelDto hotelDto){
        return modelMapper.map(hotelDto, Hotel.class);
    }

    public static Hotel convertToDto (HotelDto hotelDto){
        return modelMapper.map(hotelDto, Hotel.class);
    }

}
