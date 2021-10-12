package br.com.achei.scpsurf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Max(value = 30)
    private String nmEstado;

    @NotNull
    @Max(value = 30)
    private String nmPais;

    @NotNull
    @Min(value = 9)
    private int numCep;

    private boolean isAtivo;

    @NotNull
    private Date dtAlteracao;


}
