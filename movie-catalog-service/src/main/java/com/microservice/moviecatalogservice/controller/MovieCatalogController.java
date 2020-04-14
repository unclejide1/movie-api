package com.microservice.moviecatalogservice.controller;

import com.microservice.moviecatalogservice.model.CatalogItem;
import com.microservice.moviecatalogservice.model.Movie;
import com.microservice.moviecatalogservice.model.Rating;
import com.microservice.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    private RestTemplate restTemplate;

    private WebClient.Builder webClientBuilder;

    @Autowired
    public MovieCatalogController(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    @RequestMapping("/{userid}")
    public List<CatalogItem> getCatalog( @PathVariable("userid") String userid){


        UserRating  ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"
                + userid, UserRating.class);
       return ratings.getUserRating().stream().map(rating -> {
           Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"
                   + rating.getMovieId(), Movie.class);
//           Movie movie =webClientBuilder.build().get()
//                   .uri("http://localhost:8082/movies/"
//                   + rating.getMovieId())
//                   .retrieve()
//                   .bodyToMono(Movie.class).block();
           assert movie != null;
           return new CatalogItem(movie.getName(), "interesting", rating.getRating());
       })
               .collect(Collectors.toList());
        //get all rated movie Ids
        //for each movie Id, call movie into service and get details
        //put them all together
    }

}
