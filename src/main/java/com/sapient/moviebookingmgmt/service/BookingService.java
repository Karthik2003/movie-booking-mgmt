package com.sapient.moviebookingmgmt.service;

import com.sapient.moviebookingmgmt.entity.Booking;
import com.sapient.moviebookingmgmt.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Slf4j
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Mono<Booking> getBookingDetailsById(String bookingId) {
        return bookingRepository.findById(Integer.parseInt(bookingId));
    }
    public Mono<Integer> bookSeats(String screenId, String date, String seats) {
        Booking booking = new Booking();
        booking.setScreenId(Integer.parseInt(screenId));
        booking.setDate(LocalDate.parse(date));
        booking.setSeatsBooked(Integer.parseInt(seats));
        booking.setActive(true);
        return bookingRepository.save(booking).map(Booking::getId);
    }
    public Mono<Booking> updateSeatsById(String bookingId, String seats) {
        return bookingRepository.findById(Integer.parseInt(bookingId)).flatMap(bookRepo -> {
            bookRepo.setSeatsBooked(Integer.parseInt(seats));
            return bookingRepository.save(bookRepo);
        });
    }
}