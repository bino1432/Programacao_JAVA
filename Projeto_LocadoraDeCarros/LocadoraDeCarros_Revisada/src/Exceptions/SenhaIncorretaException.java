package Exceptions;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException(){
        super("Senha Incorreta");
    }
}