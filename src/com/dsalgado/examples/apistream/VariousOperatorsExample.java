package com.dsalgado.examples.apistream;

import com.dsalgado.examples.apistream.domain.ApiUser;
import com.dsalgado.examples.apistream.domain.Invoice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VariousOperatorsExample {

    public void checkEmpties(){
        Stream<String> stream = Stream.of("", "Hola", "Mudo", "");

        long count = stream.filter(String::isEmpty).count();

        System.out.println("count = " + count);
    }

    public void checkDistinct(){
        Stream<String> stream = Stream.of("", "Hola", "Mudo", "");

        long count = stream.distinct().count();

        System.out.println("count = " + count);
    }

    public void intStreamAndStats(){
        IntStream numbers = IntStream.range(5,20);

        IntSummaryStatistics stats = numbers.summaryStatistics();

        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Avg: " + stats.getAverage());
        System.out.println("Cnt: " + stats.getCount());

        IntStream numbers2 = IntStream.rangeClosed(5,20);
        IntSummaryStatistics stats2 = numbers2.summaryStatistics();

        System.out.println("Max: " + stats2.getMax());

    }

    public void flatMapExample(){
        Stream<ApiUser> stream = Stream.of(
                "Diego Guzman",
                "Alexander Gonzalez",
                "Daniela Gutierrez",
                "Alejandra Garcia"
        ).map(user -> new ApiUser(user.split(" ")[0],user.split(" ")[1]));

        // Devolverá un stream de otro objeto
        stream.flatMap(
                user -> {
                    if (user.getName().equals("Daniela")){
                        return Stream.of(user);
                    }
                    return Stream.empty();
                }
        ).forEach(System.out::println);
    }

    public void exampleInvoice(){
        ApiUser user1 = new ApiUser("Daniela", "S.",1);
        ApiUser user2 = new ApiUser("Diego","Salgado",2);

        user1.addInvoice(new Invoice("Bicicleta"));
        user1.addInvoice(new Invoice("Tiquetes viaje"));

        user2.addInvoice(new Invoice("Curso Golang"));
        user2.addInvoice(new Invoice("Notebook"));

        List<ApiUser> users = Arrays.asList(user1,user2);

        // Recorrer todas las facturas por usuario, sería un doble for
        /*
        for (ApiUser user: users) {
            for (Invoice invoice: user.getInvoices()){

            }
        }
        */

        users.stream().flatMap(
                user -> user.getInvoices().stream()
        ).forEach(invoice -> System.out.println(invoice.getDescription()));

    }
}
