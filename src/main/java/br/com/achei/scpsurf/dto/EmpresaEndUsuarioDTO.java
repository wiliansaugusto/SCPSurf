package br.com.achei.scpsurf.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmpresaEndUsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empresaEndUsuario;
    @Column
    private String descEndereco;

}
