package com.sapient.moviebookingmgmt.repository;

import com.sapient.moviebookingmgmt.entity.Booking;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends R2dbcRepository<Booking, Integer> {
}
