package com.andreas.videoRecommentaionApi;

import com.andreas.videoRecommentaionApi.video.Video;
import com.andreas.videoRecommentaionApi.video.VideoRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class VideoRecommendationApiApplicationTests {

	@Container
	private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private MockMvc mockMvc;

	// given/when/then format BDD style
	@Test
	public void givenVideos_whenGetAllVideo_thenListOfVideos() throws Exception {
		System.out.println(postgreSQLContainer.getDatabaseName());
		System.out.println(postgreSQLContainer.getPassword());
		System.out.println(postgreSQLContainer.getUsername());
		System.out.println(postgreSQLContainer.getJdbcUrl());

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
