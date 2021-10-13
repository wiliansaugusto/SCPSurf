package br.com.achei.scpsurf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PranchaDTO {

    private Long idPrancha;
    private int tpFase;
    private String tpPrancha;
    private double largura;
    private double espessura;
    private double comprimento;
    private double litragem;
    private Date dtAlteracao;
    private Long regPrancha;

}
