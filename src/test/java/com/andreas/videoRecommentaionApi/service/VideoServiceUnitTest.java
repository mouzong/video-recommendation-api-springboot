package com.andreas.videoRecommentaionApi.service;

import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.repository.VideoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class VideoServiceUnitTest {
    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoService videoService;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateVideo() {

        // Create Video
        Video aMockVideo = new Video();
        aMockVideo.setTitle("Romeo Doit Mourrir");
        aMockVideo.setLabels(List.of("Jet-li", "Aaliyah", "KungFu"));


        // Save the video

        // Verify the video

    }
}
