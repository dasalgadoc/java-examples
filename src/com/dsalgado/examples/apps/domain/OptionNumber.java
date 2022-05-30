package com.dsalgado.examples.apps.domain;

import com.dsalgado.examples.apps.domain.exceptions.PositiveOptionsException;

public class OptionNumber {

    private Integer optionNumber;

    public OptionNumber(Integer optionNumber){

        if(optionNumber < 0){
            throw new PositiveOptionsException(optionNumber);
        }

        this.optionNumber = optionNumber;

    }

    public Integer getOptionNumber(){
        return this.optionNumber;
    }

}
