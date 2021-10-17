package br.com.achei.scpsurf.mapper;

import br.com.achei.scpsurf.dto.EnderecoDTO;
import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.entity.Endereco;
import br.com.achei.scpsurf.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoMapper {
    public List<EnderecoDTO> toDto(List<Endereco> enderecoList){
        return enderecoList.stream().map(this::toDto).collect(Collectors.toList());
    }
    public EnderecoDTO toDto(Endereco endereco){
        EnderecoDTO dto = new EnderecoDTO();
        dto.setIdEndereco(endereco.getIdEndereco());
        dto.setDtAlteracao(endereco.getDtAlteracao());
        dto.setDescComplemento(endereco.getDescComplemento());
        dto.setIsAtivoRes(endereco.getIsAtivoRes());
        dto.setNmBairro(endereco.getNmBairro());
        dto.setNmEstado(endereco.getNmEstado());
        dto.setNmPais(endereco.getNmPais());
        dto.setNmLogradouro(endereco.getNumLogradouro());
        dto.setNumCep(endereco.getNumCep());
        dto.setNumLogradouro(endereco.getNumLogradouro());
        dto.setTpEndereco(endereco.getTpEndereco());
        return dto;
        
    }

    public Endereco toEntity(EnderecoDTO enderecoDTO){
        Endereco entity = new Endereco();
        entity.setIdEndereco(enderecoDTO.getIdEndereco());
        entity.setDescComplemento(enderecoDTO.getDescComplemento());
        entity.setNmBairro(enderecoDTO.getNmBairro());
        entity.setDtAlteracao(enderecoDTO.getDtAlteracao());
        entity.setNmEstado(enderecoDTO.getNmEstado());
        entity.setNmLogradouro(enderecoDTO.getNmLogradouro());
        entity.setNmPais(enderecoDTO.getNmPais());
        entity.setNumCep(enderecoDTO.getNumCep());
        entity.setNumLogradouro(enderecoDTO.getNumLogradouro());
        entity.setIsAtivoRes(enderecoDTO.getIsAtivoRes());
        entity.setDescComplemento(enderecoDTO.getDescComplemento());
        entity.setTpEndereco(enderecoDTO.getTpEndereco());
        return entity;
    }
}
