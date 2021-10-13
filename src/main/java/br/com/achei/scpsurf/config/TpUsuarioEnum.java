package br.com.achei.scpsurf.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TpUsuarioEnum {

    ADM("Administrativo"),
    SHAPER("Shaper"),
    CLIENTEFINAL("Cliente Final");

    private final String usuarioEnum;
}
