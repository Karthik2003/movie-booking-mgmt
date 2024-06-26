package com.sapient.moviebookingmgmt.service;

import com.sapient.moviebookingmgmt.dto.Screen;
import com.sapient.moviebookingmgmt.dto.TicketAvailability;
import com.sapient.moviebookingmgmt.repository.BookingRepository;
import com.sapient.moviebookingmgmt.repository.ScreenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private BookingRepository bookingRepository;
    public void saveAll(List<Screen> screenList) {
        log.info("------ persisting all  screen data -----");
        screenRepository.saveAll(screenList);
    }

    public Flux<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Mono<TicketAvailability> checkAvailability(String screenId, String date) {
        return screenRepository.checkAvailability(Integer.parseInt(screenId), LocalDate.parse(date));
    }
}