package br.com.achei.scpsurf.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TpContatoEnum {

    WHATSAPP("Whatasapp"),
    EMAIL("E-mail"),
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    OUTRO("Outro");

    private final String tpContato;

}
