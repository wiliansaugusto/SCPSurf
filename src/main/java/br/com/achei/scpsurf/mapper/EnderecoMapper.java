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
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(enderecoDTO.getIdEndereco());
        endereco.setDescComplemento(enderecoDTO.getDescComplemento());
        endereco.setNmBairro(enderecoDTO.getNmBairro());
        endereco.setDtAlteracao(enderecoDTO.getDtAlteracao());
        endereco.setNmEstado(enderecoDTO.getNmEstado());
        endereco.setNmLogradouro(enderecoDTO.getNmLogradouro());
        endereco.setNmPais(enderecoDTO.getNmPais());
        endereco.setNumCep(enderecoDTO.getNumCep());
        endereco.setNumLogradouro(enderecoDTO.getNumLogradouro());
        endereco.setIsAtivoRes(enderecoDTO.getIsAtivoRes());
        endereco.setDescComplemento(enderecoDTO.getDescComplemento());
        endereco.setTpEndereco(enderecoDTO.getTpEndereco());
        return endereco;
    }
}
