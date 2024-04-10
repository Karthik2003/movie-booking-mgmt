package com.sapient.moviebookingmgmt.service;

import com.sapient.moviebookingmgmt.dto.Screen;
import com.sapient.moviebookingmgmt.dto.TicketAvailability;
import com.sapient.moviebookingmgmt.repository.ScreenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;
    public void saveAll(List<Screen> screenList) {
        log.info("------ persisting all  screen data -----");
        screenRepository.saveAll(screenList);
    }

    public Flux<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Mono<TicketAvailability> checkAvailability(String screenId) {
        return screenRepository.checkAvailability(screenId);
    }
}