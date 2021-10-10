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
    private Long  id_tp_usuario;

    @Column(nullable = false)
    private String nm_tp_usuario;

    @Column
    private boolean is_ativo;

    @Column
    private boolean is_adm;

    @Column
    private Date dt_alteracao;


}
