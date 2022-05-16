package com.andreas.videoRecommentaionApi.video;

import lombok.Data;

import java.util.List;
@Data
public class VideoDTO {
    private String id;
    private String title;
    private List<String> labels;
}
