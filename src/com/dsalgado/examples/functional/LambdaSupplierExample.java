package com.dsalgado.examples.functional;

import com.dsalgado.examples.functional.domain.LamdbaUser;

import java.util.function.Supplier;

public class LambdaSupplierExample {

    // Proveedor, no recibe parámetros pero devuelve un valor.

    public void basicSupplier(){
        Supplier<String> supplier = () ->{
            return "Hola, Mundo";
        };

        System.out.println(supplier.get());
    }

    public void supplierCreatesUser(){
        Supplier<LamdbaUser> supplier = () -> {
            return new LamdbaUser("Alezander", 25 );
        };

        System.out.println(supplier.get());
    }
}
