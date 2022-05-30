package com.dsalgado.examples.apistream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {

    public void streamDeclaration(){
        // Definición del Stream
        Stream<String> stream = Stream.of("Pata","Peta","Pita", "Pota");

        // Para cada elemento del Stream define un Consumer
        stream.forEach(System.out::println);
    }

    public void streamForArray(){
        String[] arr = {"Pata","Peta","Pita", "Pota"};

        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }

    public void streamForStreamBuilder(){
        Stream<String> stream = Stream.<String>builder()
                .add("Pata")
                .add("Peta")
                .add("Pita")
                .add("Pota")
                .build();

        stream.forEach(System.out::println);
    }

    public void streamForCollection(){
        List<String> myList = new ArrayList<>();

        myList.add("Pata");
        myList.add("Peta");
        myList.add("Pita");
        myList.add("Pota");

        Stream<String> stream = myList.stream();

        stream.forEach(System.out::println);
    }

    public void streamToList(){
        Stream<String> stream = Stream.of("Pata","Peta","Pita", "Pota");

        List<String> myList = stream.collect(Collectors.toList());

        for (String element: myList) {
            System.out.println("Elemento: " + element);
        }
    }

    public void findElementsStream(){
        // Definir un Supplier que devolverá un Stream
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("Pata","Peta","Pita", "Pota");

        Optional<String> random = streamSupplier.get().findAny();
        System.out.println("Aleatorio: " + random.get());

        Optional<String> first = streamSupplier.get().findFirst();
        System.out.println("Primero: " + first.get());

    }

    public void countStreamElements(){
        Stream<String> stream = Stream.of("Pata","Peta","Pita", "Pota");

        long count = stream.count();

        System.out.println("El stream contiene: (" + count + ") Elementos");
    }

    public void infiniteStreamWithGenerate(Integer limit){
        // Sin el atributo limit, será infinito

        Stream.generate(() -> "Hola mundo").limit(limit).forEach(System.out::println);
    }
}
