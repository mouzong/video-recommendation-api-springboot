package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VideoService {
    public ResponseEntity<List<VideoDto>> getAll();

    public ResponseEntity<VideoDto> create(Video video);
}
