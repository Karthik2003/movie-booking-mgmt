package com.sapient.moviebookingmgmt.repository;


import com.sapient.moviebookingmgmt.dto.Screen;
import com.sapient.moviebookingmgmt.dto.TicketAvailability;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface ScreenRepository extends R2dbcRepository<Screen, Integer> {
    String availablityQuery = """
                               SELECT s.id AS SCREEN_ID, s.name AS SCREEN_NAME, s.capacity AS TOTAL_CAPACITY,
                                    SUM(b.seatsBooked) AS SEATS_BOOKED, s.capacity - SUM(b.seatsBooked) AS SEATS_AVAILABLE
                               FROM screen s JOIN booking b ON s.id = b.screenId
                               WHERE s.id = :screenId and b.date = :date and b.bookingactive = true
                              """;

    String bookingQuery = """
                           SELECT s.id AS SCREEN_ID, s.name AS SCREEN_NAME, s.capacity AS TOTAL_CAPACITY,
                                SUM(b.seatsBooked) AS SEATS_BOOKED, s.capacity - SUM(b.seatsBooked) AS SEATS_AVAILABLE
                           FROM screen s JOIN booking b ON s.id = b.screenId
                           WHERE s.id = :screenId and b.date = :date and b.bookingactive = true
                          """;
    @Query(availablityQuery)
    Mono<TicketAvailability> checkAvailability(@Param("screenId") Integer screenId, @Param("date") LocalDate date);

    @Query(bookingQuery)
    void bookSeats(@Param("screenId") Integer screenId, @Param("date") LocalDate date, @Param("seats") Integer seats);

}