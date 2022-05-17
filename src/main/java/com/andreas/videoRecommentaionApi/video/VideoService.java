package com.andreas.videoRecommentaionApi.video;

import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VideoService {
    public ResponseEntity<VideoDTO> create(Video video);

    public List<VideoDTO> getAll();

    public List<String> getDeletedIds();

    public ResponseEntity<VideoDTO> getById(String videoId) throws ResourceNotFoundException;

    public ResponseEntity<VideoDTO> delete(String videoId) throws ResourceNotFoundException;

    public ResponseEntity<VideoDTO> update(Video video) throws ResourceNotFoundException;

    public List<VideoDTO> getAllByTitle(String videoTitle);
}
