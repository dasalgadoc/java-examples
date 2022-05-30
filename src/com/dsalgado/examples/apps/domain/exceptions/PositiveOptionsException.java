package com.dsalgado.examples.apps.domain.exceptions;

public class PositiveOptionsException extends RuntimeException{

    private static final String MESSAGE = "Sólo se permiten optionces ";

    public PositiveOptionsException(Integer numberOption){
        super(String.format(MESSAGE + "%d",numberOption));
    }

}
