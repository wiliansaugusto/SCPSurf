package br.com.achei.scpsurf.entity;


import br.com.achei.scpsurf.config.EnderecoEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEndereco;

    @Column
    @NotNull
    private String nmLogradouro;

    @Column
    @NotNull
    private String numLogradouro;

    @Column
    private String descComplemento;

    @Column
    @NotNull
    private String nmBairro;

    @Column
    @NotNull
    private String nmEstado;

    @Column
    @NotNull
    private String nmPais;

    @Column
    private String numCep;

    @Column
    @NotNull
    private int isAtivoRes;

    @Column
    private ZonedDateTime dtAlteracao;

    @Column
    @NotNull
    private EnderecoEnum tpEndereco;

    public ZonedDateTime setDtAlteracao() {
        return  this.dtAlteracao = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
