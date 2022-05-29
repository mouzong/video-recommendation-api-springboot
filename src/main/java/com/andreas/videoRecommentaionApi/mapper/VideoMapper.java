package com.andreas.videoRecommentaionApi.mapper;

import com.andreas.videoRecommentaionApi.dto.VideoDto;
import com.andreas.videoRecommentaionApi.entity.Video;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoMapper {



    public VideoDto entityToDto(Video video){
        ModelMapper modelMapper = new ModelMapper();
        VideoDto videoDto = new VideoDto();
        videoDto = modelMapper.map(video, VideoDto.class);
        return videoDto;
    }

    public Video dtoToEntity(VideoDto videoDto){
        ModelMapper modelMapper = new ModelMapper();
        Video video = new Video();
        video = modelMapper.map(videoDto, Video.class);
        return video;
    }

    public List<VideoDto> entityToDto(List<Video> videos){
        return videos.stream()
                .map(video -> entityToDto(video))
                .collect(Collectors.toList());
    }

    public List<Video> dtoToEntity(List<VideoDto> videoDtos){
        return videoDtos.stream()
                .map(videoDto -> dtoToEntity(videoDto))
                .collect(Collectors.toList());
    }
}
