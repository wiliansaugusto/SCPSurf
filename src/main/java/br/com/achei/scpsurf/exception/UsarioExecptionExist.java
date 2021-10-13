package br.com.achei.scpsurf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsarioExecptionExist extends Exception{
    public UsarioExecptionExist(String nmUsuario) {
        super(String.format("Usuario with name %s already registered in the system.", nmUsuario));
    }
}
