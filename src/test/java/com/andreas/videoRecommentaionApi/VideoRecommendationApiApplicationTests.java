package com.andreas.videoRecommentaionApi;

import com.andreas.videoRecommentaionApi.entity.Video;
import com.andreas.videoRecommentaionApi.repository.VideoRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
class VideoRecommendationApiApplicationTests {
	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private MockMvc mockMvc;

	// given/when/then format BDD style
	@Test
	public void givenVideos_whenGetAllVideo_thenListOfVideos() throws Exception {
		// given - setup precondition
		List<Video> videos = List.of(
				Video.builder().id(String.valueOf(UUID.randomUUID())).title("No time to die").labels(List.of("James Bond", "007")).build(),
				Video.builder().id(String.valueOf(UUID.randomUUID())).title("Dr Mobius").labels(List.of("Action ", "Horror")).build(),
				Video.builder().id(String.valueOf(UUID.randomUUID())).title("Dr House").labels(List.of("Hospital", "Sorrow")).build()
		);
		videoRepository.saveAll(videos);

		// when - action
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/videos"));

		// then - verify output
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(videos.size())));
	}

}
