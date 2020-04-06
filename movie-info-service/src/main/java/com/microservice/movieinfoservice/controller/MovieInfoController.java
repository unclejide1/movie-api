package com.microservice.movieinfoservice.controller;

import com.microservice.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @RequestMapping("/{movieid}")
    public Movie getMovieInto(@PathVariable("movieid") String movieid){
        return new Movie(movieid, "test-name");

    }
}
