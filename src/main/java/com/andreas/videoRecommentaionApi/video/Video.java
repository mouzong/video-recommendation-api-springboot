package com.andreas.videoRecommentaionApi.video;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "videos")
public class Video {

     public static List<String> DELETED_IDS = new ArrayList<>();

     @Id
     @GeneratedValue(generator = "uuid")
     @GenericGenerator(name="uuid", strategy = "uuid2")
     private String id;

     @Column(name = "title")
     protected String title;

     @Column(name = "labels")
     @ElementCollection(targetClass = String.class)
     protected List<String> labels;

}
