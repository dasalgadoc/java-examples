package com.dsalgado.examples.apps.domain;

import com.dsalgado.examples.apps.domain.exceptions.AlreadyExistsOptionException;

import java.util.List;

public class OptionsPrevious {
    private List<Integer> previousOptions;

    public OptionsPrevious(OptionNumber optionNumber, List<Integer> previousOptions){

        if(previousOptions.contains(optionNumber.getOptionNumber())){
            throw new AlreadyExistsOptionException(optionNumber.getOptionNumber());
        }

        this.previousOptions = previousOptions;
    }

    public List<Integer> getPreviousOptions(){
        return this.previousOptions;
    }
}
