package com.andreas.videoRecommentaionApi.video;

import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VideoService {
    public ResponseEntity<VideoDTO> create(Video video);

    public List<Video> getAll();

    public List<String> getDeletedIds();

    public ResponseEntity<Video> getById(String videoId) throws ResourceNotFoundException;

    public ResponseEntity delete(String videoId) throws ResourceNotFoundException;

    public ResponseEntity<Video> update(Video video) throws ResourceNotFoundException;

    public List<Video> getAllByTitle(String videoTitle);
}
