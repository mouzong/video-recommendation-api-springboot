package com.andreas.videoRecommentaionApi.serie;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService{

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SerieDTO convertSerieEntityToSerieDTO(Serie serie){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        SerieDTO serieDTO = new SerieDTO();
        serieDTO = modelMapper.map(serie, SerieDTO.class);
        return serieDTO;
    }

    public Serie convertSerieDTOToSerieEntity(SerieDTO serieDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        Serie serie = new Serie();
        serie = modelMapper.map(serieDTO, Serie.class);
        return serie;
    }
    @Override
    public List<SerieDTO> getAll() {
        return serieRepository.findAll()
                .stream()
                .map(this::convertSerieEntityToSerieDTO)
                .collect(Collectors.toList());
    }
}
