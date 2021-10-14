package br.com.achei.scpsurf.entity;

import br.com.achei.scpsurf.config.TpUsuarioEnum;
import br.com.achei.scpsurf.mapper.UsuarioMapper;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private boolean isAtivo;

}
