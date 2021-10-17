package br.com.achei.scpsurf.controller;

import br.com.achei.scpsurf.dto.ContatoDTO;
import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.entity.Contato;
import br.com.achei.scpsurf.exception.ContatoExecptionExist;
import br.com.achei.scpsurf.exception.UsarioExecptionExist;
import br.com.achei.scpsurf.service.ContatoService;
import br.com.achei.scpsurf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContatoDTO> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(contatoService.findById(id));
    }

    @GetMapping(value = "/findall" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContatoDTO>> findAll() throws ContatoExecptionExist {
        return ResponseEntity.ok(contatoService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ContatoDTO createContato(@RequestBody @Valid ContatoDTO contatoDTO) throws  ContatoExecptionExist {
        return contatoService.createContato(contatoDTO);
    }

    @PutMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public ContatoDTO updateContato(@RequestBody @Valid ContatoDTO contatoDTO, Long id) throws ContatoExecptionExist {
        return contatoService.updateContato(id, contatoDTO);
    }

}
