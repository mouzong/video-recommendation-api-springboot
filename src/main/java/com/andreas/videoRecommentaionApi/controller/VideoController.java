package com.andreas.videoRecommentaionApi.controller;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {
    @Autowired
    private final VideoService videoService;

    public VideoController(VideoService videoService) {

        this.videoService = videoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<VideoDto>> getAll(){

        return videoService.getAll();
    }

    @PostMapping
    public void create(VideoDto videoDto){
        return videoService.create(videoDto);
    }
}
