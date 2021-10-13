package br.com.achei.scpsurf.service;

import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.entity.Usuario;
import br.com.achei.scpsurf.exception.UsarioExecptionExist;
import br.com.achei.scpsurf.mapper.UsuarioMapper;
import br.com.achei.scpsurf.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository ;

    @Autowired
    private final UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) throws UsarioExecptionExist {
        verifyIfIsAlreadyRegistered(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(savedUsuario);
    }
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return (List<UsuarioDTO>) usuarioMapper.toDto((Usuario) usuarioRepository.findAll());
    }
    @Transactional
    private void verifyIfIsAlreadyRegistered(UsuarioDTO usuarioDTO) throws UsarioExecptionExist {
        Optional<Usuario> optSavedUsuario = usuarioRepository.FindByNumCpf(usuarioDTO.getNumCpf());
        if (optSavedUsuario.isPresent()) throw new UsarioExecptionExist(String.valueOf(usuarioDTO.getNmUsuario()));
    }
}
