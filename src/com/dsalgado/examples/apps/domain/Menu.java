package com.dsalgado.examples.apps.domain;

import java.util.List;

public class Menu {

    private List<Option> options;

    public Menu(List<Option> options) {
        this.options = options;
    }

    public List<Option> getOptions(){
        return this.options;
    }
}
