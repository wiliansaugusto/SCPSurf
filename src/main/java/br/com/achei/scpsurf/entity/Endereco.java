package br.com.achei.scpsurf.entity;


import br.com.achei.scpsurf.config.EnderecoEnum;
import lombok.*;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @Column(name="id_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column
    private String nmLogradouro;

    @Column
    private String numLogradouro;

    @Column
    private String descComplemento;

    @Column
    private String nmBairro;

    @Column
    private String nmEstado;

    @Column
    private String nmPais;

    @Column
    private String numCep;

    @Column
    private int isAtivoRes;

    @Column
    private ZonedDateTime dtAlteracao;

    @Column
    private EnderecoEnum tpEndereco;

    public ZonedDateTime setDtAlteracao() {
        return  this.dtAlteracao = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }


}
