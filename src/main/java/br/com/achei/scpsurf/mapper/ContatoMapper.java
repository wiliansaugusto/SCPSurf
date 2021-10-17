package br.com.achei.scpsurf.mapper;

import br.com.achei.scpsurf.dto.ContatoDTO;
import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.entity.Contato;
import br.com.achei.scpsurf.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContatoMapper {

    public List<ContatoDTO> toDto(List<Contato> listContato){
        return listContato.stream().map(this::toDto).collect(Collectors.toList());
    }
     public ContatoDTO toDto(Contato contato){
        ContatoDTO dto = new ContatoDTO();
        dto.setIdContato(contato.getIdContato());
        dto.setDescContato(contato.getDescContato());
        dto.setTpContato(contato.getTpContato());
        dto.setIsAtivoContato(contato.getIsAtivoContato());
        return dto;
     }
     public Contato toEntity(ContatoDTO contatoDTO){
        Contato contato = new Contato();
        contato.setTpContato(contatoDTO.getTpContato());
        contato.setIdContato(contatoDTO.getIdContato());
        contato.setDescContato(contatoDTO.getDescContato());
        contato.setIsAtivoContato(contatoDTO.getIsAtivoContato());
        return contato;
     }


}
