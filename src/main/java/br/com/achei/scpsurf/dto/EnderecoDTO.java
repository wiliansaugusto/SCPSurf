package br.com.achei.scpsurf.dto;

import br.com.achei.scpsurf.config.EnderecoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class EnderecoDTO {

    private  Long idEndereco;

    @NotNull
    @Size(min=4, max = 100)
    private String nmLogradouro;

    @NotNull
    private String numLogradouro;

    private String descComplemento;

    @NotNull
    private String nmBairro;

    @NotNull
    private String nmEstado;

    @NotNull
    private String nmPais;

    @NotNull
    @Size(min = 8)
    private String numCep;

    private int isAtivoRes;

    private ZonedDateTime dtAlteracao;

    @NotNull
    private EnderecoEnum tpEndereco;


}
