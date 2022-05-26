package com.andreas.videoRecommentaionApi.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Serie")
public class Serie  extends  Video{
    private String author;
}
