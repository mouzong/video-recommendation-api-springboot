package com.andreas.videoRecommentaionApi.controller;

import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }


    // Create a video
    @PostMapping
    public Video create(@Validated @RequestBody Video video) {
        return videoService.create(video);
    }


    // Get a video by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Video> getById(@PathVariable(value = "id") String videoId)
            throws ResourceNotFoundException {
        return videoService.getById(videoId);
    }

    // Get all videos
    @GetMapping
    public List<Video> getAll() {
        return videoService.getAll();
    }


    // Delete a video by ID
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String videoId)
            throws ResourceNotFoundException {
        return videoService.delete(videoId);
    }


    // Update a video
    @PutMapping("/{id}")
    public ResponseEntity<Video> update(@PathVariable(value = "id") String videoId, @RequestBody Video video)
            throws ResourceNotFoundException {
        return videoService.update(videoId, video);

    }

    // Get videos from sample title "vid"
    @GetMapping("/title/{title}")
    public List<Video> getAllByTitle(@PathVariable(value = "title") String videoTitle) {
        return videoService.getAllByTitle(videoTitle);

    }

    // Get ID of deleted videos
    public List<String> getDeletedIds() {
        return videoService.getDeletedIds();
    }

}
