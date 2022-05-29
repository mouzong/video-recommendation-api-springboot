package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import com.andreas.videoRecommentaionApi.mapper.VideoMapper;
import com.andreas.videoRecommentaionApi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public ResponseEntity<List<VideoDto>> getAll() {
        List<VideoDto> videos = videoMapper.entityToDto(videoRepository.findAll());

        return ResponseEntity.ok().body(videos);
    }

    @Override
    public ResponseEntity<VideoDto> create(Video video) {
        VideoDto videoDto = videoMapper.entityToDto(videoRepository.save(video));
        return ResponseEntity.ok(videoDto);
    }

    @Override
    public ResponseEntity<VideoDto> getById(String videoId) throws ResourceNotFoundException {
        VideoDto videoDto = videoMapper.entityToDto(videoRepository.findById(UUID.fromString(videoId))
                .orElseThrow(()-> new ResourceNotFoundException("Video with ID : "+videoId+" not found")));
        return ResponseEntity.ok(videoDto);
    }
}
