package com.sapient.moviebookingmgmt.controller;

import com.sapient.moviebookingmgmt.dto.Screen;
import com.sapient.moviebookingmgmt.dto.TicketAvailability;
import com.sapient.moviebookingmgmt.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/screen")
public class ScreenController {
    @Autowired
    private ScreenService screenService;
    @GetMapping("/getAll")
    public Flux<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }
    @GetMapping("/checkAvailability/{id}/{date}")
    public Mono<TicketAvailability> checkAvailability(@PathVariable("id") String screenId, @PathVariable("date") String date) {
        return screenService.checkAvailability(screenId, date);
    }
    @PostMapping("/book/{id}/{date}/{seats}")
    public void bookSeats(@PathVariable("id") String screenId, @PathVariable("date") String date, @PathVariable("seats") String seats) {
        screenService.bookSeats(screenId, date, seats);
    }

}
