package br.com.achei.scpsurf.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnderecoEnum {

    COMERCIAL("Comercial"),
    RESIDENCIAL("Residencial"),
    LOJA("Loja");

    private final String enderecoEnum;
}
