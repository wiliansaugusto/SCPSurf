package br.com.achei.scpsurf.dto;


import br.com.achei.scpsurf.config.TpContatoEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContatoDTO {

    private Long idContato;

    @NotNull
    private TpContatoEnum tpContato;

    @NotNull
    @Size(min = 9, max = 200)
    private String descContato;

    private int isAtivoContato;
}
