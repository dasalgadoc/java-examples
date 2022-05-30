package com.dsalgado.examples.apistream.domain;

import java.util.ArrayList;
import java.util.List;

public class ApiUser {
    private Integer ID;
    private String name;
    private String lastName;

    private List<Invoice> invoices;

    public ApiUser(String name, String lastName) {

        validateName(name);
        validateLastName(lastName);

        this.name = name;
        this.lastName = lastName;
        this.ID = 0;
        this.invoices = new ArrayList<>();
    }

    public ApiUser(String name, String lastName, Integer ID) {

        validateName(name);
        validateLastName(lastName);
        validateID(ID);

        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.invoices = new ArrayList<>();
    }

    public ApiUser(String name, String lastName, Integer ID, List<Invoice> invoices){

        validateName(name);
        validateLastName(lastName);
        validateID(ID);

        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.invoices = invoices;

    }

    private void validateName(String name){
        if (name.isEmpty()){
            throw new RuntimeException("Name shouldn't be empty");
        }
    }

    private void validateLastName(String lastName){
        if (lastName.isEmpty()){
            throw new RuntimeException("Last Name shoul'd be empty");
        }
    }

    public void validateID(Integer ID){
        if(ID <= 0 || ID == null){
            throw new RuntimeException("ID should be possitive and not null: (" + ID + ")");
        }
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public List<Invoice> getInvoices(){
        return this.invoices;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "ApiUser{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

}
