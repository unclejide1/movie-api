package com.microservice.moviecatalogservice.controller;

import com.microservice.moviecatalogservice.model.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @RequestMapping("/{userid}")
    public List<CatalogItem> getCatalog( @PathVariable("userid") String userid){
        return  Collections.singletonList(new CatalogItem("Bad boys", "intereting", 5));
    }

}
