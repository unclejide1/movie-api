package com.microservice.ratingsdataservice.controllers;

import com.microservice.ratingsdataservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @RequestMapping("/{movieid}")
    public Rating getRating(@PathVariable("movieid") String movieid){
        return new Rating(movieid, 4);

    }
}
