package com.domain.hotelbooking.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
public class FetchHotelsRequest {

    private String place;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
