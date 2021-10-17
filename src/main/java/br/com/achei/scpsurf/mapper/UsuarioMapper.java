package br.com.achei.scpsurf.mapper;

import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UsuarioMapper {

    public List<UsuarioDTO> toDto(List<Usuario> listUsuario){
        return listUsuario.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNmUsuario(usuario.getNmUsuario());
        dto.setDescGenero(usuario.getDescGenero());
        dto.setDtNascimento(usuario.getDtNascimento());
        dto.setNomeCompleto(usuario.getNomeCompleto());
        dto.setTpUsuario(usuario.getTpUsuario());
        dto.setPassword(usuario.getPassword());
        dto.setNumCpf(usuario.getNumCpf());
        dto.setDtAlteracao(usuario.getDtAlteracao());
        dto.setIsAtivoUsuario(usuario.getIsAtivoUsuario());
        return dto;
    }
    public Usuario toEntity(UsuarioDTO usuarioDTO){

        Usuario usuario =new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setNmUsuario(usuarioDTO.getNmUsuario());
        usuario.setDescGenero(usuarioDTO.getDescGenero());
        usuario.setDtNascimento(usuarioDTO.getDtNascimento());
        usuario.setNomeCompleto(usuarioDTO.getNomeCompleto());
        usuario.setTpUsuario(usuarioDTO.getTpUsuario());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setNumCpf(usuarioDTO.getNumCpf());
        usuario.setDtAlteracao(usuarioDTO.getDtAlteracao());
        usuario.setIsAtivoUsuario(usuarioDTO.getIsAtivoUsuario());
        return usuario;
    }


}
