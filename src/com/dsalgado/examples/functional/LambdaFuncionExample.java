package com.dsalgado.examples.functional;

import com.dsalgado.examples.functional.domain.LamdbaUser;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaFuncionExample {

    // Los functions combinan el consumidor y el supplier al recibir y devolver algo

    public void lambdaFunctionBasic(){
        Function<String, String> function = (name) -> {
          return "Hola " + name;
        };

        System.out.println(function.apply("Diego"));
    }

    public void lambdaBiFunctions(){
        BiFunction<String, Integer, LamdbaUser> bf = (name, age) -> {
          return new LamdbaUser(name,age);
        };

        System.out.println(bf.apply("Diego",30));
    }
}
