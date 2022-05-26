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
@DiscriminatorValue("Film")
public class Film extends  Video{
    private String actor;
}
