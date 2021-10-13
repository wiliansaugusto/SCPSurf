package br.com.achei.scpsurf.dto;

import br.com.achei.scpsurf.config.TpUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {

    private Long idUsuario;
    @NotNull
    @Size(min = 3, max = 30)
    private String nmUsuario;

    @NotNull
    @Min(value = 6)
    private String password;

    @NotNull
    private Date dtNascimento;

    @NotNull
    private String descGenero;

    @NotNull
    private int numCpf;

    @NotNull
    @Size(min = 5, max = 45)
    private String nomeCompleto;

    @NotNull
    private TpUsuarioEnum tpUsuario;
    //private long FKTpUsuario;
}
