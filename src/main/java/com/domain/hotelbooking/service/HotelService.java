package com.domain.hotelbooking.service;

import com.domain.hotelbooking.entity.Hotel;
import com.domain.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public ResponseEntity<Hotel> getHotelById(Long hotelId) {
        Hotel hotel = this.hotelRepository.findById(hotelId).orElse(null);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    public ResponseEntity<Hotel> createHotel(Hotel hotel) {
        Hotel newHotel = new Hotel();

        newHotel.setName(hotel.getName());
        newHotel.setEmail(hotel.getEmail());
        newHotel.setAddress(hotel.getAddress());
        newHotel.setPhoneNumber(hotel.getPhoneNumber());
        newHotel.setWebsite(hotel.getWebsite());

        this.hotelRepository.save(newHotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
