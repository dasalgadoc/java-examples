package com.dsalgado.examples.apps.domain.exceptions;

public class NoEmptiesStringException extends RuntimeException{

    private static final String MESSAGE = "Mo se permiten cadenas vacías en el objeto";

    public NoEmptiesStringException(){
        super(MESSAGE);
    }

}
