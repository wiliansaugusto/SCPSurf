package br.com.achei.scpsurf.controller;

import br.com.achei.scpsurf.dto.PranchaDTO;
import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.exception.PranchaExecptionExist;
import br.com.achei.scpsurf.exception.UsarioExecptionExist;
import br.com.achei.scpsurf.service.PranchaService;
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
@RequestMapping("/v1/prancha")
public class PranchaController {

    @Autowired
    private PranchaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PranchaDTO> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/findall" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PranchaDTO>> findAll() throws PranchaExecptionExist {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public PranchaDTO createPrancha(@RequestBody @Valid PranchaDTO pranchaDTO) throws PranchaExecptionExist {
        return service.createPrancha(pranchaDTO);
    }

    @PutMapping(value = "/updateprancha/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public PranchaDTO updatePrancha(@RequestBody @Valid PranchaDTO pranchaDTO, Long id) throws PranchaExecptionExist {
        return service.updatePrancha(id, pranchaDTO);
    }

}
