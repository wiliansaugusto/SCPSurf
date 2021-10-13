package br.com.achei.scpsurf.entity;


import jdk.jfr.BooleanFlag;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity @Data
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PranchaPropiedade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropiedadePrancha;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtGravacao;

    @Column
    @BooleanFlag
    private boolean isAtivo;

}
