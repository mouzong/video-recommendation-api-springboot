package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VideoService {
    public Video create(Video video);

    public List<Video> getAll();

    public List<String> getDeletedIds();

    public ResponseEntity<Video> getById(String videoId) throws ResourceNotFoundException;

    public ResponseEntity delete(String videoId) throws ResourceNotFoundException;

    public ResponseEntity<Video> update(Video video);

    public ResponseEntity<Video> update(String videoId, Video video) throws ResourceNotFoundException;

    public List<Video> getAllByTitle(String videoTitle);
}
