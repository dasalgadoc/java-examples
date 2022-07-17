package com.dsalgado.examples.apistream;

import com.dsalgado.examples.apistream.domain.ApiUser;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {

    public void nullWrapper(){
        Stream<String> stream = Stream.of("Papa","Pepe","Pipi","Popo");

        Optional<String> resultNotNull = stream.filter(q -> q.equals("Papax")).findFirst();

        System.out.println(resultNotNull.orElse("John Doe"));

    }

    public void optionalOrElseGet(){
        Stream<String> stream = Stream.of("Papa","Pepe","Pipi","Popo");

        Optional<String> resultNotNull = stream.filter(q -> q.equals("Papax")).findFirst();

        System.out.println(resultNotNull.orElseGet(() -> new ApiUser("John","Doe").toString()));
    }

    public void optionalCheckPresentEmpty(){
        Stream<String> stream = Stream.of("Papa","Pepe","Pipi","Popo");

        Optional<String> resultNotNull = stream.filter(q -> q.equals("Papax")).findFirst();

        if (resultNotNull.isPresent()){
            System.out.println("Objeto presente");
        }

        if (!resultNotNull.isPresent()){
            System.out.println("Objeto vacío");
        }

    }


}
