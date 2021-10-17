package br.com.achei.scpsurf.service;


import br.com.achei.scpsurf.dto.EnderecoDTO;
import br.com.achei.scpsurf.entity.Contato;
import br.com.achei.scpsurf.entity.Endereco;
import br.com.achei.scpsurf.exception.ContatoExecptionExist;
import br.com.achei.scpsurf.exception.EnderecoExecptionExist;
import br.com.achei.scpsurf.mapper.EnderecoMapper;
import br.com.achei.scpsurf.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiremock.org.apache.commons.codec.EncoderException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;


    @Transactional
    public  EnderecoDTO createEndereco(EnderecoDTO enderecoDTO)throws EnderecoExecptionExist{
        verifyIfIsAlreadyRegistered(enderecoDTO);
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco.setDtAlteracao();
        Endereco enderecoSaved = enderecoRepository.save(endereco);
        return enderecoMapper.toDto(enderecoSaved);
    }

    @Transactional
    public EnderecoDTO updateEndereco(Long id, EnderecoDTO enderecoDTO) throws EnderecoExecptionExist{
        Optional<Endereco> enderecoExits= enderecoRepository.findById(id);
        if(enderecoExits.isPresent()){
            Endereco endereconNovo = new Endereco();
            endereconNovo.setTpEndereco(enderecoDTO.getTpEndereco());
            endereconNovo.setDtAlteracao();
            endereconNovo.setDescComplemento(enderecoDTO.getDescComplemento());
            endereconNovo.setNumLogradouro(enderecoDTO.getNumLogradouro());
            endereconNovo.setNumCep(enderecoDTO.getNumCep());
            endereconNovo.setNmPais(enderecoDTO.getNmPais());
            endereconNovo.setNmLogradouro(enderecoDTO.getNmLogradouro());
            endereconNovo.setNmEstado(enderecoDTO.getNmEstado());
            endereconNovo.setIsAtivoRes(enderecoDTO.getIsAtivoRes());
            enderecoRepository.save(endereconNovo);
            return enderecoMapper.toDto(endereconNovo);
        }
            return null;

    }

    @Transactional
    void verifyIfIsAlreadyRegistered(EnderecoDTO enderecoDTO) throws EnderecoExecptionExist {
        Optional<Endereco> optSavedEndereco= enderecoRepository.findById(enderecoDTO.getIdEndereco());
        if (optSavedEndereco.isPresent()) throw new EnderecoExecptionExist(String.valueOf(enderecoDTO.getIdEndereco()));
    }

    @Transactional(readOnly = true)
    public EnderecoDTO findById(Long id) throws Exception {
        return enderecoRepository.findById(id).map(enderecoMapper::toDto).orElseThrow(Exception::new);
    }

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findAll(){
        return  enderecoMapper.toDto(enderecoRepository.findAll());
    }




}
