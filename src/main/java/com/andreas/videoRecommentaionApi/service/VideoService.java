package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VideoService {
    public ResponseEntity<List<VideoDto>> getAll();
}
