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
    private  Long id_endereco;

    @Column
    @NotNull
    private String nm_logradouro;

    @Column
    @NotNull
    private String num_logradouro;

    @Column
    private String desc_complemento;

    @Column
    @NotNull
    private String nm_bairro;

    @Column
    @NotNull
    private String nm_estado;

    @Column
    @NotNull
    private String nm_pais;

    @Column
    @Digits(integer = 9, fraction = 0)
    private int num_cep;

    @Column
    @NotNull
    private boolean is_ativo;

    @Column
    @NotNull
    private Date dt_alteracao;
}
