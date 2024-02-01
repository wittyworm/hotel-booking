package com.domain.hotelbooking.repository;

import com.domain.hotelbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
