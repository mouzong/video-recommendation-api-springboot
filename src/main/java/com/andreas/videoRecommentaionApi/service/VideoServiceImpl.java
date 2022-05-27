package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
