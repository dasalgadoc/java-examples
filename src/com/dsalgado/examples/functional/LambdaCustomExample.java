package com.dsalgado.examples.functional;

import com.dsalgado.examples.functional.domain.Arithmetics;

public class LambdaCustomExample {

    private double lambdaCustom(double a, double b, Arithmetics lambda){
        return lambda.operation(a,b);
    }

    public void lambdaCustomBasic(Integer num1, Integer num2){
        Arithmetics sum = (a, b) -> {
            return a + b;
        };

        Arithmetics substract = (a,b) -> {
            return a - b;
        };

        Arithmetics multiply = (a,b) -> {
            return a * b;
        };

        System.out.println(sum.operation(num1,num2));
        System.out.println(substract.operation(num1,num2));
        System.out.println(multiply.operation(num1,num2));

    }
}
