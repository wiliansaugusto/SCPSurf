package br.com.achei.scpsurf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuarioDTO {

    private Long  id_tp_usuario;

    @NotNull
    @Size(min=4, max = 100)
    private String nm_tp_usuario;

    private boolean is_ativo;

    private boolean is_adm;

    @NotNull
    private Date dt_alteracao;

}
