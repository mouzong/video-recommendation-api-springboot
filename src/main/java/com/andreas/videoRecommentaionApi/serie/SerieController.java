package com.andreas.videoRecommentaionApi.serie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {


    @GetMapping
    public List<Serie> getAll(){
        return Seri
    }
}
