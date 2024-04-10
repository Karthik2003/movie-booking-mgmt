package com.sapient.moviebookingmgmt.repository;


import com.sapient.moviebookingmgmt.dto.Screen;
import com.sapient.moviebookingmgmt.dto.TicketAvailability;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ScreenRepository extends R2dbcRepository<Screen, Integer> {
    @Query("SELECT DISTINCT s.id AS SCREEN_ID, s.name AS SCREEN_NAME, s.capacity AS TOTAL_CAPACITY, SUM(b.seatsBooked) AS SEATS_BOOKED FROM screen s JOIN booking b ON s.id = b.screenId WHERE s.id = :screenId GROUP BY b.screenId LIMIT 1")
    Mono<TicketAvailability> checkAvailability(String screenId);
}