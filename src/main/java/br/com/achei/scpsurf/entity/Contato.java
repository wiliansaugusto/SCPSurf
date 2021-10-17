package br.com.achei.scpsurf.entity;

import br.com.achei.scpsurf.config.TpContatoEnum;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContato;

    @Column
    @NotNull
    private TpContatoEnum tpContato;

    @Column
    @NotNull
    private String descContato;

    @Column
    private int isAtivoContato;

}
