package com.andreas.videoRecommentaionApi.repository;

import com.andreas.videoRecommentaionApi.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository  extends JpaRepository<Video, UUID> {
}
