package com.andreas.videoRecommentaionApi.serie;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Builder
@Entity
@Table(name = "serie")
@DiscriminatorValue("1")
public class Serie extends  {



}
