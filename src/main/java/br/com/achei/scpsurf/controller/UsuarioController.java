package br.com.achei.scpsurf.controller;

import br.com.achei.scpsurf.dto.UsuarioDTO;
import br.com.achei.scpsurf.exception.UsarioExecptionExist;
import br.com.achei.scpsurf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping(value = "/findall" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> findAll() throws UsarioExecptionExist {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public UsuarioDTO createUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) throws UsarioExecptionExist {
        return usuarioService.createUsuario(usuarioDTO);
    }



}
