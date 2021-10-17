package br.com.achei.scpsurf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContatoExecptionExist extends Exception{
    public ContatoExecptionExist(String descContato) {
        super(String.format("Contato %s não existe no sistema.", descContato));
    }
}
