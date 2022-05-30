package com.dsalgado.examples.apistream;

import com.dsalgado.examples.apistream.domain.ApiUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParallelExample {

    public void parallelStreamBasic(){
        List<ApiUser> users = new ArrayList<>();

        users.add(new ApiUser("Diego","Salgado"));
        users.add(new ApiUser("Alexander","Castellanos"));
        users.add(new ApiUser("Daniela","S."));
        users.add(new ApiUser("Alejandra","P."));
        users.add(new ApiUser("John","Doe"));
        users.add(new ApiUser("Jane","Doe"));
        users.add(new ApiUser("María","Loreto"));
        users.add(new ApiUser("Julio","Escobar"));

        long timeStart = System.currentTimeMillis();

        String names = users.stream()
                .map(user ->
                        user.getName().toUpperCase()
                        .concat(" ")
                        .concat(user.getLastName().toUpperCase())
                        )
                .flatMap(
                        name ->
                        {
                            try{
                                TimeUnit.SECONDS.sleep(1);
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }

                            if(name.contains("Daniela".toUpperCase())){
                                return Stream.of(name);
                            }
                            return Stream.empty();
                        }
                )
                .findAny().orElse("");

        long timeEnd = System.currentTimeMillis();

        long timeStartParallel = System.currentTimeMillis();

        String names2 = users.stream()
                .parallel()
                .map(user ->
                        user.getName().toUpperCase()
                                .concat(" ")
                                .concat(user.getLastName().toUpperCase())
                )
                .flatMap(
                        name ->
                        {
                            try{
                                TimeUnit.SECONDS.sleep(1);
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }

                            if(name.contains("Daniela".toUpperCase())){
                                return Stream.of(name);
                            }
                            return Stream.empty();
                        }
                )
                .findAny().orElse("");

        long timeEndParallel = System.currentTimeMillis();

        System.out.println("Segundos para encontrar a Daniela sin paralelismo: " +  (timeEnd - timeStart)/1000);
        System.out.println("Segundos para enocntrar a Daniela con paralelismo: " + (timeEndParallel-timeStartParallel)/1000);

        System.out.println(names);
    }

}
