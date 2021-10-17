package br.com.achei.scpsurf.service;

import br.com.achei.scpsurf.dto.ContatoDTO;
import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.entity.Contato;
import br.com.achei.scpsurf.entity.Usuario;
import br.com.achei.scpsurf.exception.ContatoExecptionExist;
import br.com.achei.scpsurf.exception.UsarioExecptionExist;
import br.com.achei.scpsurf.mapper.ContatoMapper;
import br.com.achei.scpsurf.mapper.UsuarioMapper;
import br.com.achei.scpsurf.repository.ContatoRepository;
import br.com.achei.scpsurf.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private final ContatoMapper contatoMapper;

    @Transactional
    public ContatoDTO createContato(ContatoDTO contatoDTO) throws ContatoExecptionExist {
        verifyIfIsAlreadyRegistered(contatoDTO);
        Contato contato = contatoMapper.toEntity(contatoDTO);
        Contato contatoSaved = contatoRepository.save(contato);
        return contatoMapper.toDto(contatoSaved);
    }

    @Transactional(readOnly = true)
    public List<ContatoDTO> findAll() {
        return  contatoMapper.toDto(contatoRepository.findAll());
    }

    @Transactional
    void verifyIfIsAlreadyRegistered(ContatoDTO contatoDTO) throws ContatoExecptionExist {
        Optional<Contato> optSavedContato = contatoRepository.findById(contatoDTO.getIdContato());
        if (optSavedContato.isPresent()) throw new ContatoExecptionExist(String.valueOf(contatoDTO.getIdContato()));
    }
    @Transactional(readOnly = true)
    public ContatoDTO findById(long id) throws Exception {
        return contatoRepository.findById(id).map(contatoMapper::toDto).orElseThrow(Exception::new);
    }
    @Transactional
    public ContatoDTO updateContato(Long id, ContatoDTO contatoDTO) throws ContatoExecptionExist{
        Optional<Contato> contatoPresente =contatoRepository.findById(id);
        if(contatoPresente.isPresent()) {
            Contato contato = contatoPresente.get();
            Contato novoContato = contatoMapper.toEntity(contatoDTO);
            contato.setTpContato(novoContato.getTpContato());
            contato.setDescContato(novoContato.getDescContato());
            contato.setIsAtivoContato(novoContato.getIsAtivoContato());
            contatoRepository.save(contato);
            return  contatoMapper.toDto(contato);
        }

            return null;
    }
}
