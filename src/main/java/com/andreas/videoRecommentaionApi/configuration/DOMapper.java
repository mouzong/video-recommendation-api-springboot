package com.andreas.videoRecommentaionApi.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class DOMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
