package com.andreas.videoRecommentaionApi.controller;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import com.andreas.videoRecommentaionApi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VideoDto> create(@RequestBody Video video){
        return videoService.create(video);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VideoDto> getById(@PathVariable("id") String videoId) throws ResourceNotFoundException {
        return videoService.getById(videoId);
    }

    @GetMapping("/titles/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<VideoDto> getByTitle(@PathVariable("title") String videoTitle){
         return videoService.getByTitle(videoTitle);
    }
}
