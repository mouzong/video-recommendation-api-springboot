package com.andreas.videoRecommentaionApi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "VIDEO_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public class Video {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "title")
    protected String title;

    @Column(name = "titles")
    @ElementCollection(targetClass = String.class)
    protected List<String> labels;

    private static List<String> deletedVideoId;

    static {
        deletedVideoId = new ArrayList<>();
    }
}
