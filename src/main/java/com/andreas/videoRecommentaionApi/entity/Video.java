package com.andreas.videoRecommentaionApi.entity;

import lombok.*;

import javax.persistence.*;
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
    private UUID videiId;

    protected String title;

    @ElementCollection(targetClass = String.class)
    protected List<String> labels;
}
