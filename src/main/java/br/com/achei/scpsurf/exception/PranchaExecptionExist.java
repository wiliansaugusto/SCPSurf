package br.com.achei.scpsurf.exception;

public class PranchaExecptionExist extends Exception{
    public PranchaExecptionExist(String prancha){
        super(String.format("Prancha %s não existe no sistema.", prancha));

    }
}
