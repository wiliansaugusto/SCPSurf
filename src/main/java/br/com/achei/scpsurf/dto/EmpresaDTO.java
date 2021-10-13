package br.com.achei.scpsurf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class EmpresaDTO {

    private Long idEmpresa;

    @NotNull
    @Size(min = 3, max = 60)
    private String nmFantasia;

    @NotNull
    @Size(min = 3, max = 60)
    private String nmComercial;

    @NotNull
    @Max(value = 20)
    private int nmCnoj;
}
