package br.com.achei.scpsurf.entity;

import br.com.achei.scpsurf.config.TpUsuarioEnum;
import lombok.*;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nm_usuario")
    private String nmUsuario;

    @Column
    private String password;

    @Column
    private Date dtNascimento;

    @Column
    private String descGenero;

    @Column
    private Long numCpf;

    @Column
    private String nomeCompleto;

    @Column
    private TpUsuarioEnum tpUsuario;

    @Column
    private int isAtivoUsuario;

    @Column(nullable = true)
    private ZonedDateTime dtAlteracao;



      public ZonedDateTime setDtAlteracao() {
        return  this.dtAlteracao = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }


}
