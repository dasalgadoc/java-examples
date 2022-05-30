package com.dsalgado.examples.apistream.domain;

public class Invoice {

    private String description;

    public Invoice(String description){

        if (description.isEmpty()) {
            throw new RuntimeException("Description can't be empty");
        }

        this.description = description;

    }

    public String getDescription() {
        return description;
    }
}
