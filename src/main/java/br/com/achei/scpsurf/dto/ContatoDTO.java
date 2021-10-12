package br.com.achei.scpsurf.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ContatoDTO {

    private Long idContato;

    @NotNull
    private int tpContato;

    @NotNull
    @Size(min = 9, max = 100)
    private String descContato;

    private boolean isAtivo;
}
