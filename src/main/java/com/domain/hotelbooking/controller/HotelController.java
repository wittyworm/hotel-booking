package com.domain.hotelbooking.controller;

import com.domain.hotelbooking.entity.Hotel;
import com.domain.hotelbooking.model.FetchHotelsRequest;
import com.domain.hotelbooking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

//    endpoint to get hotel by hotel id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);

    }

//    endpoint to create hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }
}
