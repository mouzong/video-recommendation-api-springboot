package com.andreas.videoRecommentaionApi.repository;

import com.andreas.videoRecommentaionApi.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository  extends JpaRepository<Video, String> {

}
