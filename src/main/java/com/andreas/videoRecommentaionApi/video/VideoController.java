package com.andreas.videoRecommentaionApi.video;

import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import com.andreas.videoRecommentaionApi.video.Video;
import com.andreas.videoRecommentaionApi.video.VideoService;
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
    public ResponseEntity<VideoDTO> create(@Validated @RequestBody Video video) {

        return videoService.create(video);
    }


    // Get a video by its ID
    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> getById(@PathVariable(value = "id") String videoId)
            throws ResourceNotFoundException {
        return videoService.getById(videoId);
    }

    // Get all videos
    @GetMapping
    public List<VideoDTO> getAll() {
        return videoService.getAll();
    }


    // Delete a video by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<VideoDTO> delete(@PathVariable(value = "id") String videoId)
            throws ResourceNotFoundException {
        return videoService.delete(videoId);
    }


    // Update a video
    @PutMapping
    public ResponseEntity<VideoDTO> update(@RequestBody Video video)
            throws ResourceNotFoundException {
        return videoService.update(video);

    }

    // Get videos from sample title "vid"
    @GetMapping("/title/{title}")
    public List<VideoDTO> getAllByTitle(@PathVariable(value = "title") String videoTitle) {
        return videoService.getAllByTitle(videoTitle);

    }

    // Get ID of deleted videos
    public List<String> getDeletedIds() {
        return videoService.getDeletedIds();
    }

}
