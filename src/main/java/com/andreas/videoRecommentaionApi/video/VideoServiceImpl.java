package com.andreas.videoRecommentaionApi.video;

import com.andreas.videoRecommentaionApi.error.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private final VideoRepository videoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public VideoServiceImpl(VideoRepository videoRepository) {

        this.videoRepository = videoRepository;
    }

    public VideoDTO convertVideoEntityToVideoDto(Video video) {
        // configuration to enable referenced fields to be mapped correctly
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        VideoDTO videoDTO = new VideoDTO();
        videoDTO = modelMapper.map(video, VideoDTO.class);
        return videoDTO;
    }

    public Video convertVideoDtoToVideoEntity(VideoDTO videoDTO) {
        // configuration to enable referenced fields to be mapped correctly
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        Video video = new Video();
        video = modelMapper.map(videoDTO, Video.class);
        return video;
    }

    @Override
    public ResponseEntity<VideoDTO> create(Video video) {
        videoRepository.save(video);
        VideoDTO videoDTO = new VideoDTO();
        BeanUtils.copyProperties(video, videoDTO);

        return ResponseEntity.ok(videoDTO);

    }

    @Override
    public List<VideoDTO> getAll() {

        return videoRepository.findAll()
                .stream()
                .map(this::convertVideoEntityToVideoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDeletedIds() {
        return Video.DELETED_IDS;
    }

    @Override
    public ResponseEntity<Video> getById(String videoId) throws ResourceNotFoundException {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pas de video trouvée avec ID : " + videoId));
        return ResponseEntity.ok().body(video);
    }

    @Override
    public ResponseEntity delete(String videoId) throws ResourceNotFoundException {
        videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException(" Video not found : " + videoId));
        Video.DELETED_IDS.add(videoId);
        videoRepository.deleteById(videoId);
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Video> update(Video video) throws ResourceNotFoundException {
        Video videoFound = videoRepository.findById(video.getId())
                .orElseThrow(() -> new ResourceNotFoundException(" Video not found : " + video.getId()));
        videoFound.setLabels(video.getLabels());
        videoFound.setTitle(video.getTitle());
        videoRepository.save(videoFound);

        return ResponseEntity.ok().body(videoFound);
    }

    @Override
    public List<VideoDTO> getAllByTitle(String videoTitle) {
        List<Video> videos = videoRepository.findAll();
        return videos.stream()
                .filter(video -> video.getTitle().contains(videoTitle))
                .map(this::convertVideoEntityToVideoDto)
                .collect(Collectors.toList());
    }
}
