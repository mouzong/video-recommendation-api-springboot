package com.andreas.videoRecommentaionApi.entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("Serie")
public class Serie  extends  Video{
    private String author;
}
