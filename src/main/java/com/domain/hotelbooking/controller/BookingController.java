package com.domain.hotelbooking.controller;

import com.domain.hotelbooking.entity.Booking;
import com.domain.hotelbooking.model.BookingRequest;
import com.domain.hotelbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

//    endpoint to get booking by booking id
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

//    endpoint for creating a new booking
//    takes a json request body
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingReq) {
        return bookingService.createBooking(bookingReq);
    }

//    endpoint to cancel the booking
//    takes the booking id of the booking that needs to be cancelled
    @PutMapping("/{bookingId}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

}
