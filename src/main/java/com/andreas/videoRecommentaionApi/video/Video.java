package com.andreas.videoRecommentaionApi.video;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "video")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "video_type", discriminatorType = DiscriminatorType.INTEGER)
public class Video {

     public static List<String> DELETED_IDS = new ArrayList<>();

     @Id
     @GeneratedValue(generator = "uuid")
     @GenericGenerator(name="uuid", strategy = "uuid2")
     protected String videoId;

     @Column(name = "title")
     protected String title;

     @Column(name = "labels")
     @ElementCollection(targetClass = String.class)
     protected List<String> labels;

     public Video() {
     }

     public Video(String videoId, String title, List<String> labels) {
          this.videoId = videoId;
          this.title = title;
          this.labels = labels;
     }

     public String getVideoId() {
          return videoId;
     }

     public void setVideoId(String videoId) {
          this.videoId = videoId;
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
          return "Video{" +
                  "videoId='" + videoId + '\'' +
                  ", title='" + title + '\'' +
                  ", labels=" + labels +
                  '}';
     }
}
