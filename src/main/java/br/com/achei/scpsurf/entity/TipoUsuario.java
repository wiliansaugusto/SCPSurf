package br.com.achei.scpsurf.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idTpUsuario;

    @Column(nullable = false)
    private String nmTpUsuario;

    @Column
    private boolean isAtivo;

    @Column
    private boolean isAdm;

    @Column
    private Date dtAlteracao;


}
