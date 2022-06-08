package com.andreas.videoRecommentaionApi.dto;


import com.andreas.videoRecommentaionApi.entity.Video;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class VideoDto {
    private UUID id;
    private String title;
    private List<String> labels;

    public VideoDto(UUID id, String title, List<String> labels) {
        this.id = id;
        this.title = title;
        this.labels = labels;
    }

    public VideoDto() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "VideoDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", labels=" + labels +
                '}';
    }

    public void fromEntityToDto(Video video){


    }
}
