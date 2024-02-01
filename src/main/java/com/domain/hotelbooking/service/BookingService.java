package com.domain.hotelbooking.service;

import com.domain.hotelbooking.entity.Booking;
import com.domain.hotelbooking.entity.Hotel;
import com.domain.hotelbooking.entity.User;
import com.domain.hotelbooking.model.BookingRequest;
import com.domain.hotelbooking.repository.BookingRepository;
import com.domain.hotelbooking.repository.HotelRepository;
import com.domain.hotelbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public ResponseEntity<Booking> getBookingById(Long bookingId) {
//        fetching booking by booking id from database
        Booking booking = this.bookingRepository.findById(bookingId).orElse(null);
        if(booking == null){
//            TODO: throw exception
        }

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    public ResponseEntity<Booking> createBooking(BookingRequest bookingReq) {
//        fetching user and hotel from database to create a booking entry in database
        User user = this.userRepository.findById(bookingReq.getUserId()).orElse(null);
        Hotel hotel = this.hotelRepository.findById(bookingReq.getHotelId()).orElse(null);
        if(user == null){
//            TODO : Throw Exception
        }

        if(hotel == null){
//            TODO: Throw exception
        }

        Booking newBooking = new Booking();

        newBooking.setUser(user);
        newBooking.setHotel(hotel);
        newBooking.setCheckInDate(bookingReq.getCheckInDate());
        newBooking.setCheckOutDate(bookingReq.getCheckOutDate());
        newBooking.setNumGuests(bookingReq.getNumGuests());
        newBooking.setNumRooms(bookingReq.getNumRooms());
        newBooking.setPrice(bookingReq.getPrice());
        newBooking.setIsCancelled(false);

        this.bookingRepository.save(newBooking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    public ResponseEntity<Booking> cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if(booking == null){
//          TODO: thorw exception
        }
        booking.setIsCancelled(true);
        bookingRepository.save(booking);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
