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
        Mono<TicketAvailability> mono = screenService.checkAvailability(screenId, date);
        mono.subscribe(ticketAvailability -> {
            if(ticketAvailability.getSeatsAvailable() == 0) {
                ticketAvailability.setSeatsAvailable(ticketAvailability.getTotalCapacity());
            }
        });

        return mono;
    }
}