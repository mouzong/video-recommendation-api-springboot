package com.andreas.videoRecommentaionApi.dto;


import java.util.List;
import java.util.UUID;

public class VideoDto {
    private UUID videoId;
    private String title;
    private List<String> labels;
}
