package com.dsalgado.examples.cleancode;

public class Chapter3 {

    /*
     *  1: Pagina 63: Switch case functions
     *  Note: This code its illystrative.
     */

    // Bad Code

    private static final String COMMISIONED = "COMMISIONED";
    private static final String HOURLY = "HOURLY";
    private static final String SALARIED = "SALARIED";

    class Money{}

    class Employee{
        public String type;
    }

    class InvalidEmployeeType extends RuntimeException{
        public InvalidEmployeeType(Object e){
            throw new RuntimeException("Illustrative Code");
        }
    }

    public Money calculateCommisionedPay(Employee e){
        throw new RuntimeException("Illustrative Code");
    }

    public Money calculateHourlyPay(Employee e){
        throw new RuntimeException("Illustrative Code");
    }
    public Money calculateSalariedPay(Employee e){
        throw new RuntimeException("Illustrative Code");
    }

    public Money calculatePay(Employee e) throws InvalidEmployeeType{
        switch (e.type){
            case COMMISIONED:
                return calculateCommisionedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            default:
                throw new InvalidEmployeeType(e.type);
        }
    }

    /*
     *  2: Pagina 78: Ejecución de excepciones
     *  Note: This code its illystrative.
     */



}
