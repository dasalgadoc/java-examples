package com.dsalgado.examples.functional;

import com.dsalgado.examples.functional.domain.LamdbaUser;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaFuncionExample {

    // Los functions combinan el consumidor y el supplier al recibir y devolver algo

    public void lambdaFunctionBasic(){
        System.out.println("----- lambdaFunctionBasic -----");
        Function<String, String> function = (name) -> {
          return "Hola " + name;
        };

        System.out.println(function.apply("Diego"));
    }

    public void lambdaBiFunctions(){
        System.out.println("----- lambdaBiFunction -----");
        BiFunction<String, Integer, LamdbaUser> bf = (name, age) -> {
          return new LamdbaUser(name,age);
        };

        System.out.println(bf.apply("Diego",30));
    }


    public void functionExample(){
        System.out.println("----- functionExample -----");
        String letterA = "A";
        String letterB = "B";
        String letterC = "C";

        List<String> allLetters = List.of(letterA, letterB, letterC);

        //allLetters.stream().forEach(x -> {
        //    System.out.println(validateLetterB(x));
        //});

        allLetters.stream().forEach(x -> {
            boolean validator = validateLetterB(x);
            System.out.println(validator);
            if (validator){
                System.out.println("Terminé");
                return;
            }
        });

    }

    private boolean validateLetterB(String letterValidate){
        return letterValidate.equals("B");
    }
}
