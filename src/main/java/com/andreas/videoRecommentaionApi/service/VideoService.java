package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface VideoService {
    public ResponseEntity<List<VideoDto>> getAll();

    public ResponseEntity<VideoDto> create(Video video);

    public ResponseEntity<VideoDto> getById(String videoId) throws ResourceNotFoundException;

    public List<VideoDto> getByTitle(String videoTitle);
}
