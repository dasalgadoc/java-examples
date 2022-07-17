package com.dsalgado.examples.apps.domain;

import com.dsalgado.examples.apps.domain.exceptions.NoEmptiesStringException;

public class OptionTitle {

    private final String optionTitle;

    public OptionTitle(String optionTitle){

        if(optionTitle.isEmpty()){
            throw new NoEmptiesStringException();
        }

        this.optionTitle = optionTitle;

    }

    public String getOptionTitle(){
        return this.optionTitle;
    }

}
