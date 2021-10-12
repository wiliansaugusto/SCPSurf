package br.com.achei.scpsurf.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEnderco;

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
    @Digits(integer = 9, fraction = 0)
    private int numCep;

    @Column
    @NotNull
    private boolean isAtivo;

    @Column
    @NotNull
    private Date dtAlteracao;
}
