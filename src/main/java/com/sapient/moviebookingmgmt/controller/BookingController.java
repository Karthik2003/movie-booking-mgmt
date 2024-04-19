package com.sapient.moviebookingmgmt.controller;

import com.sapient.moviebookingmgmt.entity.Booking;
import com.sapient.moviebookingmgmt.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/{screenId}/{date}/{seats}")
    public Mono<Integer> bookSeats(@PathVariable("screenId") String screenId, @PathVariable("date") String date, @PathVariable("seats") String seats) {
        return bookingService.bookSeats(screenId, date, seats);
    }
    @GetMapping("/{id}")
    public Mono<Booking> getBookingDetailsById(@PathVariable("id") String bookingId) {
        return bookingService.getBookingDetailsById(bookingId);
    }
    @PutMapping("/{id}/{seats}")
    public Mono<Booking> updateSeatsById(@PathVariable("id") String bookingId, @PathVariable("seats") String seats) {
        return bookingService.updateSeatsById(bookingId, seats);
    }

}