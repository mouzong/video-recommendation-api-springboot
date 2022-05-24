package com.andreas.videoRecommentaionApi.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    private UUID videiId;

    @Column(name = "title")
    private String title;

    @Column(name = "labels")
    @ElementCollection(targetClass = String.class)
    private List<String> labels;
}
