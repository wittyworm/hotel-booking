package com.domain.hotelbooking.model;

import lombok.*;

import java.time.LocalDate;

@Data
public class BookingRequest  {
    private Long userId;
    private Long hotelId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numGuests;
    private Integer numRooms;
    private Double price;
}
