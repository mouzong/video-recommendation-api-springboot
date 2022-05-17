package com.andreas.videoRecommentaionApi.serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {
    @Autowired
    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }


    @GetMapping
    public List<SerieDTO> getAll() {
        return serieService.getAll();
    }
}
