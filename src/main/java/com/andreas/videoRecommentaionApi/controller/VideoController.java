package com.andreas.videoRecommentaionApi.controller;

import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import com.andreas.videoRecommentaionApi.model.Video;
import com.andreas.videoRecommentaionApi.repository.VideoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VideoController {
    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    // Create a video
    @PostMapping("/videos")
    public Video createVideo(@Validated @RequestBody Video video) {
        return videoRepository.save(video);
    }


    // Get a video by its ID
    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable(value = "id") String videoId)
            throws ResourceNotFoundException {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pas de video trouvée avec ID : " + videoId));
        return ResponseEntity.ok().body(video);
    }

    // Get all videos
    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }


    // Delete a video by ID
    @DeleteMapping("/videos/{id}")
    public ResponseEntity deleteVideo(@PathVariable(value = "id") String videoId)
            throws ResourceNotFoundException {
        videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException(" Video not found : " + videoId));
        videoRepository.deleteById(videoId);
        return ResponseEntity.ok().build();
    }


    // Update a video
    @PutMapping("/videos/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable(value = "id") String videoId, @RequestBody Video video)
            throws ResourceNotFoundException {
        Video videoFound = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException(" Video not found : " + videoId));
        videoFound.setLabels(video.getLabels());
        videoFound.setTitle(video.getTitle());
        videoRepository.save(videoFound);

        return ResponseEntity.ok().body(videoFound);

    }

    // Get videos from sample title "vid"

    // Get ID of deleted videos

}
