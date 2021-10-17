package br.com.achei.scpsurf.dto;

import br.com.achei.scpsurf.config.TpUsuarioEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private Long idUsuario;

    @NotNull
    @Size(min = 3, max = 30)
    private String nmUsuario;

    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    private Date dtNascimento;

    @NotNull
    private String descGenero;

    @NotNull
    private Long numCpf;

    @NotNull
    @Size(min = 5, max = 45)
    private String nomeCompleto;

    @NotNull
    private TpUsuarioEnum tpUsuario;

    @NotNull
    private int isAtivoUsuario;

    private ZonedDateTime dtAlteracao;


    //private long FKTpUsuario;
}
