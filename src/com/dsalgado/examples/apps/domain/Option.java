package com.dsalgado.examples.apps.domain;

import java.util.List;

public class Option {

    private OptionNumber optionNumber;
    private OptionsPrevious optionPrevious;
    private OptionTitle optionTitle;
    private OptionMethod optionMethod;

    public Option(Integer optionNumber,
                  List<Integer> optionPrevious,
                  String optionTitle,
                  String optionMethod){

        this.optionNumber = new OptionNumber(optionNumber);
        this.optionPrevious = new OptionsPrevious(this.optionNumber,optionPrevious);
        this.optionTitle = new OptionTitle(optionTitle);
        this.optionMethod = new OptionMethod(optionMethod);

    }

}
