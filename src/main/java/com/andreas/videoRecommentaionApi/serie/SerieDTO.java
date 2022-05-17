package com.andreas.videoRecommentaionApi.serie;

import lombok.Data;

import java.util.List;

@Data
public class SerieDTO {
    private String id;
    private String title;
    private int number_of_episodes;
    private List<String> labels;
}
