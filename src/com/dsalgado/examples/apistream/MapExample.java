package com.dsalgado.examples.apistream;

import com.dsalgado.examples.apistream.domain.ApiUser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample {

    // Modifica los elementos de un flujo
    public void simpleMapExample(){
        Stream<String> stream = Stream.of("www","xxx","yyy","zzz");

        // El map devuelve el objeto cambiado

        stream.map(name -> {
            return name.toUpperCase();
        }).forEach(System.out::println);
    }

    public void mapUsingObjects(){
        Stream<String> stream = Stream.of("Pata Guzman", "Peta Gonzalez", "Pita Gutierrez", "Pota Garcia");

        stream.map(
                apiUser ->
                {
                    return new ApiUser(apiUser.split(" ")[0], apiUser.split(" ")[1]);
                }
        ).forEach(System.out::println);
    }

    public void mapUsingObjectsAnSavedIntoList(){
        Stream<ApiUser> stream =
                Stream.of("Pata Guzman", "Peta Gonzalez", "Pita Gutierrez", "Pota Garcia")
                        .map(
                                apiUser ->
                                {
                                    return new ApiUser(apiUser.split(" ")[0], apiUser.split(" ")[1]);
                                });

        List<ApiUser> myList = stream.collect(Collectors.toList());

        System.out.println(myList.getClass());
    }



}
