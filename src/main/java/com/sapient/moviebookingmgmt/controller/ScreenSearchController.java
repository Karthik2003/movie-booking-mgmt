package com.sapient.moviebookingmgmt.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.sapient.moviebookingmgmt.entity.Screens;
import com.sapient.moviebookingmgmt.service.ScreenSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/screens")
public class ScreenSearchController {
    @Autowired
    private ScreenSearchService screenSearchService;
    @PostMapping("/saveAll")
    public Iterable<Screens> saveAllScreens(@RequestBody  Iterable<Screens> screens) {
        return screenSearchService.saveAllScreens(screens);
    }
    @GetMapping("/findAll")
    public Iterable<Screens> findAll() {
        return screenSearchService.getScreens();
    }
    @PostMapping(value="/search")
    public Iterable<Screens> searchResult(@RequestBody JsonNode searchInput) {

        String screenName = Optional.ofNullable(searchInput.get("screenName").textValue()).get();
        String area = Optional.ofNullable(searchInput.get("area").textValue()).get();
        String city = Optional.ofNullable(searchInput.get("city").textValue()).get();
        String movieName = Optional.ofNullable(searchInput.get("movieName").textValue()).get();
        String movieTime = Optional.ofNullable(searchInput.get("movieTime").textValue()).get();

        if (!screenName.isBlank() && !area.isBlank()
                && !city.isBlank() && !movieName.isBlank()
                && !movieTime.isBlank()) {
            return screenSearchService.findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(screenName, area, city, movieName, movieTime);
        } else if (screenName.isBlank() && !area.isBlank()
                && !city.isBlank() && !movieName.isBlank()
                && !movieTime.isBlank()) {
            return screenSearchService.findByAreaAndCityAndMovieNameAndMovieTime(area, city, movieName, movieTime);
        } else if (screenName.isBlank() && area.isBlank()
                && !city.isBlank() && !movieName.isBlank()
                && !movieTime.isBlank()) {
            return screenSearchService.findByCityAndMovieNameAndMovieTime(city, movieName, movieTime);
        } else if (screenName.isBlank() && area.isBlank()
                && city.isBlank() && !movieName.isBlank()
                && !movieTime.isBlank()) {
            return screenSearchService.findByMovieNameAndMovieTime(movieName, movieTime);
        } else if (screenName.isBlank() && area.isBlank()
            && city.isBlank() && movieName.isBlank()
            && !movieTime.isBlank()) {
            return screenSearchService.findByMovieTime(movieTime);
        } else if (screenName.isBlank() && area.isBlank()
                && city.isBlank() && !movieName.isBlank()
                && movieTime.isBlank()) {
            return screenSearchService.findByMovieName(movieName);
        } else if (screenName.isBlank() && area.isBlank()
                && !city.isBlank() && movieName.isBlank()
                && movieTime.isBlank()) {
            return screenSearchService.findByCity(city);
        } else if (screenName.isBlank() && !area.isBlank()
                && city.isBlank() && movieName.isBlank()
                && movieTime.isBlank()) {
            return screenSearchService.findByArea(area);
        } else if (!screenName.isBlank() && area.isBlank()
                && city.isBlank() && movieName.isBlank()
                && movieTime.isBlank()) {
            return screenSearchService.findByScreenName(screenName);
        } else {
            return screenSearchService.getScreens();
        }
    }
}
