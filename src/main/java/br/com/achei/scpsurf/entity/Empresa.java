package br.com.achei.scpsurf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @Column
    private String nmFantasia;
    @Column
    private String nmComercial;
    @Column
    private int nmCnoj;
}
