package com.sapient.moviebookingmgmt.repository;

import com.sapient.moviebookingmgmt.entity.Screens;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ScreenSearchRepository extends ElasticsearchRepository<Screens, Integer> {
        Iterable<Screens> findByScreenName(String screenName);
        Iterable<Screens> findByArea(String area);
        Iterable<Screens> findByCity(String city);
        Iterable<Screens> findByMovieName(String movieName);
        Iterable<Screens> findByMovieTime(String movieTime);
        Iterable<Screens> findByMovieNameAndMovieTime(String movieName, String movieTime);
        Iterable<Screens> findByCityAndMovieNameAndMovieTime(String city, String movieName, String movieTime);
        Iterable<Screens> findByAreaAndCityAndMovieNameAndMovieTime(String area, String city, String movieName, String movieTime);
        Iterable<Screens> findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(String screenName, String area, String city, String movieName, String movieTime);
}