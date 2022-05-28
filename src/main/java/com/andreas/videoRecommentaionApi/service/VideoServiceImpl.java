package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
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
    private ModelMapper modelMapper;

    public VideoDto convertVideoEntityToVideoDto(Video video){
        VideoDto mappedVideoDto = new VideoDto();
        mappedVideoDto = modelMapper.map(video, VideoDto.class);
        return mappedVideoDto;
    }

    public Video convertVideoDtoToVideoEntity(VideoDto videoDto){
        Video mappedVideoEntity = new Video();
        mappedVideoEntity = modelMapper.map(videoDto, Video.class);
        return mappedVideoEntity;
    }

    @Override
    public ResponseEntity<List<VideoDto>> getAll() {
        List<VideoDto> videos = videoRepository.findAll()
                .stream()
                .map(video -> this.convertVideoEntityToVideoDto(video))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(videos);
    }
}
