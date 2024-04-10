package com.sapient.moviebookingmgmt.service;

import com.sapient.moviebookingmgmt.entity.Screens;
import com.sapient.moviebookingmgmt.repository.ScreenSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScreenSearchService {
    @Autowired
    private ScreenSearchRepository screenSearchRepository;
    public Iterable<Screens> getScreens() {
        return screenSearchRepository.findAll();
    }
    public Iterable<Screens> findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(String screenName, String area, String city, String movieName, String movieTime) {
        return screenSearchRepository.findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(screenName, area, city, movieName, movieTime);
    }
    public Iterable<Screens> findByAreaAndCityAndMovieNameAndMovieTime(String area, String city, String movieName, String movieTime) {
        return screenSearchRepository.findByAreaAndCityAndMovieNameAndMovieTime(area, city, movieName, movieTime);
    }
    public Iterable<Screens> findByCityAndMovieNameAndMovieTime(String city, String movieName, String movieTime) {
        return screenSearchRepository.findByCityAndMovieNameAndMovieTime(city, movieName, movieTime);
    }
    public Iterable<Screens> findByMovieNameAndMovieTime(String movieName, String movieTime) {
        return screenSearchRepository.findByMovieNameAndMovieTime(movieName, movieTime);
    }
    public Iterable<Screens> findByMovieTime(String movieTime) {
        return screenSearchRepository.findByMovieTime(movieTime);
    }
    public Iterable<Screens> findByMovieName(String movieName) {
        return screenSearchRepository.findByMovieName(movieName);
    }
    public Iterable<Screens> findByCity(String city) {
        return screenSearchRepository.findByCity(city);
    }
    public Iterable<Screens> findByArea(String area) {
        return screenSearchRepository.findByArea(area);
    }
    public Iterable<Screens> findByScreenName(String screenName) {
        return screenSearchRepository.findByScreenName(screenName);
    }
    public Iterable<Screens> saveAllScreens(Iterable<Screens> product) {
        return screenSearchRepository.saveAll(product);
    }
}