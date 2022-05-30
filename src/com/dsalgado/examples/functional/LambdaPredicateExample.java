package com.dsalgado.examples.functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class LambdaPredicateExample {

    public void lambdaPredicateBasic(){

        // Función para retornar un booleano

        Predicate<Integer> predicate = number -> {
          return number % 2 == 0;
        };

        System.out.println(predicate.test(100));
    }

    public void lambdaBiPredicate(){

        BiPredicate<Integer, Integer> predicate = (denominator, divisor) ->{
          return denominator % divisor == 0;
        };

        System.out.println(predicate.test(100,25));
    }
}
