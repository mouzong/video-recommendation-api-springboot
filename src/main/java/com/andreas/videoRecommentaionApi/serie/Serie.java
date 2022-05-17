package com.andreas.videoRecommentaionApi.serie;

import com.andreas.videoRecommentaionApi.video.Video;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Builder
@Entity
@Table(name = "serie")
public class Serie extends Video {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "numberOfEpisodes", nullable = false)
    private int number_of_episodes;

}
