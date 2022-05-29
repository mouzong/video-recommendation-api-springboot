package com.andreas.videoRecommentaionApi.dto;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class VideoDto {
    private UUID videoId;
    private String title;
    private List<String> labels;
}
