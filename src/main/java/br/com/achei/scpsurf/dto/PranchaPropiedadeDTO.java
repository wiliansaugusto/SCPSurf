package br.com.achei.scpsurf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PranchaPropiedadeDTO {

    private Long idPropiedadePrancha;

    @NotNull
    private Date dtGravacao;

    @NotNull
    private boolean isAtivo;

}
