package br.com.achei.scpsurf.controller;


import br.com.achei.scpsurf.dto.ContatoDTO;
import br.com.achei.scpsurf.dto.EnderecoDTO;
import br.com.achei.scpsurf.exception.ContatoExecptionExist;
import br.com.achei.scpsurf.exception.EnderecoExecptionExist;
import br.com.achei.scpsurf.exception.UsarioExecptionExist;
import br.com.achei.scpsurf.service.ContatoService;
import br.com.achei.scpsurf.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @GetMapping(value = "/findall" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EnderecoDTO>> findAll() throws UsarioExecptionExist {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public EnderecoDTO createEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) throws EnderecoExecptionExist {
        return enderecoService.createEndereco(enderecoDTO);
    }

    @PutMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDTO updateEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO, Long id) throws EnderecoExecptionExist {
        return enderecoService.updateEndereco(id, enderecoDTO);
    }
}
