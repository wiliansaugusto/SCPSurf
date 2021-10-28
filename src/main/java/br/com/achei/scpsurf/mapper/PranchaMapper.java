package br.com.achei.scpsurf.mapper;

import br.com.achei.scpsurf.dto.PranchaDTO;
import br.com.achei.scpsurf.entity.Prancha;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PranchaMapper {

    public List<PranchaDTO> toDto(List<Prancha> listarPrancha){
        return listarPrancha.stream().map(this::toDto).collect(Collectors.toList());
    }



    public PranchaDTO toDto(Prancha prancha){
        PranchaDTO dto = new PranchaDTO();

        dto.setIdPrancha(prancha.getIdPrancha());
        dto.setTpPrancha(prancha.getTpPrancha());
        dto.setTpFase(prancha.getTpFase());
        dto.setDtAlteracao(prancha.getDtAlteracao());
        dto.setRegPrancha(prancha.getRegPrancha());
        dto.setLitragem(prancha.getLitragem());
        dto.setLargura(prancha.getLargura());
        dto.setEspessura(prancha.getEspessura());
        dto.setComprimento(prancha.getComprimento());

        return dto;
    }
    public Prancha toEntity(PranchaDTO pranchaDTO){
        Prancha entity = new Prancha();

        entity.setIdPrancha(pranchaDTO.getIdPrancha());
        entity.setTpPrancha(pranchaDTO.getTpPrancha());
        entity.setTpFase(pranchaDTO.getTpFase());
        entity.setDtAlteracao(pranchaDTO.getDtAlteracao());
        entity.setRegPrancha(pranchaDTO.getRegPrancha());
        entity.setLitragem(pranchaDTO.getLitragem());
        entity.setLargura(pranchaDTO.getLargura());
        entity.setEspessura(pranchaDTO.getEspessura());
        entity.setComprimento(pranchaDTO.getComprimento());

        return entity;
    }
}
