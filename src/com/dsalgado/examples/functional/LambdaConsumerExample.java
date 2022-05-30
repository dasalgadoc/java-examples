package com.dsalgado.examples.functional;

import com.dsalgado.examples.functional.domain.LamdbaUser;

import java.text.SimpleDateFormat;
import java.util.*;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LambdaConsumerExample {

    // Consumidores: Los consummidores emplean funciones que no retornan ningún valor pero pueden recibir parámetros
    // https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html

    public void lambdaSimpleConsumer(){
        Consumer<Date> consumer = date -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(date));
        };

        consumer.accept(new Date());
    }

    public void lambdaBiConsumer(String nameInput, Integer ageInput){

        BiConsumer<String, Integer> biconsumer = (String name, Integer age) -> {
            System.out.println("Hola " + name + " con " + age +" años");
        };

        biconsumer.accept(nameInput, ageInput);
    }

    public void lambdaContracted(String string){
        Consumer<String> consumer = System.out::println;
        consumer.accept(string);
    }

    public void lambdaAppliedToList(List<String> list){
        Consumer<String> consumer = System.out::println;

        list.forEach(consumer);
    }

    public void lambdaAppliedToObjects(){
        Map<String, Integer> users = new HashMap<>();

        users.put("Diego",30);
        users.put("Daniela",28);
        users.put("Invalid!",999);

        List<LamdbaUser> registredUsers = new ArrayList<>();

        BiConsumer<String, Integer> consumer = (name, age) -> {
            try{
                registredUsers.add(new LamdbaUser(name, age));
            }catch(Exception ex){
                System.out.println("Error al crear el usuario: " + name);
                System.out.println(ex.toString());
            }

        };

        users.forEach(consumer);

        for(LamdbaUser lb: registredUsers){
            System.out.println("Usuario: " + lb.getName());
            System.out.println("Age: " + lb.getAge());
            System.out.println("--------------------------");
        }
    }
}
