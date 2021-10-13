package br.com.achei.scpsurf.entity;

import br.com.achei.scpsurf.config.TpUsuarioEnum;
import br.com.achei.scpsurf.mapper.UsuarioMapper;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column
    private String nmUsuario;

    @Column
    private String password;

    @Column
    private Date dtNascimento;

    @Column
    private String descGenero;

    @Column
    private int numCpf;

    @Column
    private String nomeCompleto;

    @Column
    private TpUsuarioEnum tpUsuario;
}
