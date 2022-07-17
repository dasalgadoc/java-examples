package com.dsalgado.examples.apps.domain;

import com.dsalgado.examples.apps.domain.exceptions.NoEmptiesStringException;

public class OptionMethod {
    private final String method;

    public OptionMethod(String method){

        if(method.isEmpty()){
            throw new NoEmptiesStringException();
        }

        this.method = method;
    }

    public String getMethod(){
        return this.method;
    }
}
