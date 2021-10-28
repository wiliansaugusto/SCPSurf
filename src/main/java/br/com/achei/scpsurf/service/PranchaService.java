package br.com.achei.scpsurf.service;


import br.com.achei.scpsurf.dto.EnderecoDTO;
import br.com.achei.scpsurf.dto.PranchaDTO;
import br.com.achei.scpsurf.entity.Endereco;
import br.com.achei.scpsurf.entity.Prancha;
import br.com.achei.scpsurf.exception.EnderecoExecptionExist;
import br.com.achei.scpsurf.exception.PranchaExecptionExist;
import br.com.achei.scpsurf.mapper.PranchaMapper;
import br.com.achei.scpsurf.repository.PranchaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PranchaService {


    @Autowired
    private PranchaRepository pranchaRepository;

    @Autowired
    private PranchaMapper pranchaMapper;



    private Long ContarPranchas(){
        return pranchaRepository.count();

    }

    @Transactional
    public PranchaDTO createPrancha(PranchaDTO pranchaDTO)throws PranchaExecptionExist {
        verifyIfIsAlreadyRegistered(pranchaDTO);
        Prancha prancha = pranchaMapper.toEntity(pranchaDTO);
        prancha.setDtAlteracao();
        String reg = prancha.setRegPrancha() + ContarPranchas();
        prancha.setRegPrancha(reg);
        Prancha pranchaSaved = pranchaRepository.save(prancha);
        return pranchaMapper.toDto(pranchaSaved);
    }

    @Transactional
    public PranchaDTO updatePrancha(Long id, PranchaDTO pranchaDTO) throws PranchaExecptionExist{
        Optional<Prancha> pranchaExist= pranchaRepository.findById(id);
        if(pranchaExist.isPresent()){
            Prancha prancha = pranchaMapper.toEntity(pranchaDTO);
            prancha.setDtAlteracao();
            pranchaRepository.save(prancha);
            return pranchaMapper.toDto(prancha);
        }
        return null;

    }

    void verifyIfIsAlreadyRegistered(PranchaDTO pranchaDTO) throws PranchaExecptionExist {
        Optional<Prancha> optSavedPrancha= pranchaRepository.findById(pranchaDTO.getIdPrancha());
        if (optSavedPrancha.isPresent()) throw new PranchaExecptionExist(String.valueOf(pranchaDTO.getIdPrancha()));
    }

    @Transactional(readOnly = true)
    public PranchaDTO findById(Long id) throws Exception {
        return pranchaRepository.findById(id).map(pranchaMapper::toDto).orElseThrow(Exception::new);
    }

    @Transactional(readOnly = true)
    public List<PranchaDTO> findAll(){
        return  pranchaMapper.toDto(pranchaRepository.findAll());
    }

}
