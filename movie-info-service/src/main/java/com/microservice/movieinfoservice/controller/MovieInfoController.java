package com.microservice.movieinfoservice.controller;

import com.microservice.movieinfoservice.models.Movie;
import com.microservice.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @Value("${api.key}")
    private String api_key;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieid}")
    public Movie getMovieInfo(@PathVariable("movieid") String movieid) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"
                + movieid + "?api_key=" + api_key, MovieSummary.class);
        System.out.println("got here");
        System.out.println(api_key);
        return new Movie(movieid, movieSummary.getTitle(), movieSummary.getOverview());

    }
}
