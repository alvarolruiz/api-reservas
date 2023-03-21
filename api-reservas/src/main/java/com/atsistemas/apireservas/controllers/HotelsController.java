package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.controllers.Err.ResourceNotFoundException;
import com.atsistemas.apireservas.dtos.HotelDto;
import com.atsistemas.apireservas.entities.Hotel;
import com.atsistemas.apireservas.services.HotelsService;
import com.atsistemas.apireservas.utilities.mappers.HotelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("hotels")
public class HotelsController {

    private HotelsService hotelsService;

    public HotelsController(HotelsService service) {
        this.hotelsService = service;
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hotel>> findAll(){
        return ResponseEntity.ok(hotelsService.findAllHotels());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findById(@PathVariable(name = "id") Integer id){
        return hotelsService.findHotelById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save (@Valid @RequestBody HotelDto hotelDto){
        Hotel hotel = HotelMapper.convertToEntity(hotelDto);
        hotelsService.createHotel(hotel);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update (@PathVariable (value = "id") Integer id, @Valid @RequestBody HotelDto hotelDto){
        hotelDto.setId(id);
        hotelsService.updateHotel(id, HotelMapper.convertToEntity(hotelDto));
        return new ResponseEntity(HttpStatus.OK);

    }


}
