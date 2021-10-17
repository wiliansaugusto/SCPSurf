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

import java.time.LocalDateTime;
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
        usuario.setDtAlteracao();
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(savedUsuario);
    }
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return  usuarioMapper.toDto(usuarioRepository.findAll());
    }

    @Transactional
    void verifyIfIsAlreadyRegistered(UsuarioDTO usuarioDTO) throws UsarioExecptionExist {
        Optional<Usuario> optSavedUsuario = usuarioRepository.FindByNumCpf(usuarioDTO.getNumCpf());
        if (optSavedUsuario.isPresent()) throw new UsarioExecptionExist(String.valueOf(usuarioDTO.getNmUsuario()));
    }
    @Transactional(readOnly = true)
    public UsuarioDTO findById(long id) throws Exception {
        return usuarioRepository.findById(id).map(usuarioMapper::toDto).orElseThrow(Exception::new);
    }
    @Transactional
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) throws UsarioExecptionExist{
        Optional<Usuario> usuarioPresenteDto  =  usuarioRepository.findById(id);
        if(usuarioPresenteDto.isPresent()) {
            Usuario usuario = usuarioPresenteDto.get();
            Usuario usuarioNovo = usuarioMapper.toEntity(usuarioDTO);
            usuario.setNmUsuario(usuarioNovo.getNmUsuario());
            usuario.setTpUsuario(usuarioNovo.getTpUsuario());
            usuario.setDescGenero(usuarioNovo.getDescGenero());
            usuario.setNomeCompleto(usuarioNovo.getNomeCompleto());
            usuario.setNumCpf(usuarioNovo.getNumCpf());
            usuario.setPassword(usuarioNovo.getPassword());
            usuario.setIsAtivoUsuario(usuarioNovo.getIsAtivoUsuario());
            usuario.setDtNascimento(usuarioNovo.getDtNascimento());
            usuario.setDtAlteracao();
            usuarioRepository.save(usuario);
            return  usuarioMapper.toDto(usuario);
        }


        return null;
    }


}
