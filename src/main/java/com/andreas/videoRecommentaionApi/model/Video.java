package com.andreas.videoRecommentaionApi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video {

     public static List<String> deletedVideosId = new ArrayList<>();

     @Id
     @GeneratedValue(generator = "uuid")
     @GenericGenerator(name="uuid", strategy = "uuid2")
     private String id;

     @Column(name = "title")
     protected String title;

     @Column(name = "labels")
     @ElementCollection(targetClass = String.class)
     protected List<String> labels;

     public Video() {
     }

     public Video(String id, String title, List<String> labels) {
          this.id = id;
          this.title = title;
          this.labels = labels;
     }


     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
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
}
