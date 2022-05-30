package com.dsalgado.examples.apistream;

import com.dsalgado.examples.apistream.domain.ApiUser;

import java.util.stream.Stream;

public class FilterExample {

    // Recibe una expresión del tipo Predicate
    public void basicFilter(){
        Stream<String> stream = Stream.of(
                "Pata", "Peta","Pita", "Pota", "Maria"
        ).filter(q -> q.contains("P"));

        stream.forEach(System.out::println);
    }

    public void usingFilterWithAttributes(){
        Stream<ApiUser> stream =
                Stream.of("Pata Guzman 1", "Peta Gonzalez 2", "Pita Gutierrez 3", "Pota Garcia 4")
                        .map(
                                apiUser ->
                                {
                                    return new ApiUser(apiUser.split(" ")[0], apiUser.split(" ")[1], Integer.parseInt(apiUser.split(" ")[2]));
                                });

        stream.filter(q -> q.getID().equals(2))
                .forEach(System.out::println);
    }

    // Verifica si éxiste cualquiera

    public void existsAnyInStream(){
        Stream<String> stream = Stream.of(
                "Pata", "Peta","Pita", "Pota", "Maria"
        );

        if(stream.anyMatch(q -> !q.contains("P"))) {
            System.out.println("A alguien no le gusta este juego");
        }

    }

}
