package com.microservice.ratingsdataservice.controllers;

import com.microservice.ratingsdataservice.model.Rating;
import com.microservice.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @RequestMapping("/{movieid}")
    public Rating getRating(@PathVariable("movieid") String movieid) {
        return new Rating(movieid, 4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList
                (new Rating("1234", 4), new Rating("5678", 3));

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
