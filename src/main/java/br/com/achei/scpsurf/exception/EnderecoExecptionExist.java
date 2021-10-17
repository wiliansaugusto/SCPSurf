package br.com.achei.scpsurf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnderecoExecptionExist extends Exception {
    public EnderecoExecptionExist(String idEnderco) {
        super(String.format("Endereço %s não existe no sistema.", idEnderco));
    }
}
