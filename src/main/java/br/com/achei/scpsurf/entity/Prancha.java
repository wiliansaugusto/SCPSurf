package br.com.achei.scpsurf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Prancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrancha;

    @Column
    private int tpFase;

    @Column
    private String tpPrancha;

    @Column
    private double largura;

    @Column
    private double espessura;

    @Column
    private double comprimento;

    @Column
    private double litragem;

    @Column
    private Date dtAlteracao;

    @Column
    private Long regPrancha;

}
