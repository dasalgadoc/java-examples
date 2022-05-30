package com.dsalgado.examples.apistream;

import java.util.stream.Stream;

public class ReduceExample {

    public void simpleReduceExample(){
        Stream<Integer> stream = Stream.of(0,1,1,2,3,5,8,13);

        // Parámetros:
            // Identity => Valor con el que inicia el acumulador
            // Accumulator => Función Lambda que concatena, el valor anterior y el valor actual
        int total = stream.reduce(0,(a,b) -> a + b);

        System.out.println(total);
    }
}
