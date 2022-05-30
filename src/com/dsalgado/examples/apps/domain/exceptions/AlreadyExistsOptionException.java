package com.dsalgado.examples.apps.domain.exceptions;

public class AlreadyExistsOptionException extends RuntimeException{

    private static final String MESSAGE = "Ya éxiste la opción ";

    public AlreadyExistsOptionException(Integer numberOption){
        super(String.format(MESSAGE + "%d",numberOption));
    }
}
