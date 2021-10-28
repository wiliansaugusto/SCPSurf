package br.com.achei.scpsurf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    @Column(nullable = true)
    private ZonedDateTime dtAlteracao;

    @Column(nullable = true)
    private String regPrancha;



    public ZonedDateTime setDtAlteracao() {
        return  this.dtAlteracao = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
    public String setRegPrancha(){
          ZonedDateTime dt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
          return  dt.format(DateTimeFormatter.ofPattern("YYYYMM"));
    }

}
