package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.mapper.VideoMapper;
import com.andreas.videoRecommentaionApi.repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService{

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
    public void create(VideoDto videoDto) {

    }
}
