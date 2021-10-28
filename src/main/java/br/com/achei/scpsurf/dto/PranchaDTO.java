package br.com.achei.scpsurf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PranchaDTO {

    private Long idPrancha;
    @NotNull
    private int tpFase;
    @NotNull
    private String tpPrancha;
    @NotNull
    private double largura;
    @NotNull
    private double espessura;
    @NotNull
    private double comprimento;
    @NotNull
    private double litragem;

    private ZonedDateTime dtAlteracao;
    private String regPrancha;

}
