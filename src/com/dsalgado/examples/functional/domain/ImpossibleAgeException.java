package com.dsalgado.examples.functional.domain;

public class ImpossibleAgeException extends RuntimeException{
    private static final String MESSAGE = "Inserted age is not valid!";

    public ImpossibleAgeException(Integer age){
        super(String.format(MESSAGE + " (%d)",age));
    }
}
