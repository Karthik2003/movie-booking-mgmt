package com.sapient.moviebookingmgmt.controller;

import com.sapient.moviebookingmgmt.dto.Screen;
import com.sapient.moviebookingmgmt.dto.TicketAvailability;
import com.sapient.moviebookingmgmt.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("/screen")
public class ScreenController {
    @Autowired
    private ScreenService screenService;
    @GetMapping("/getAll")
    public Flux<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/checkAvailability/{screenId}/{date}")
    public Mono<TicketAvailability> checkAvailability(@PathVariable String screenId, @PathVariable LocalDate date) {
        return screenService.checkAvailability(screenId);
    }
}
