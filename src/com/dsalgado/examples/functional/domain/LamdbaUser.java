package com.dsalgado.examples.functional.domain;

public class LamdbaUser {

    private String name;
    private Integer age;

    public LamdbaUser(String name, Integer age){
        if(name.isEmpty()){
            throw new RuntimeException("Name must to have a not empty value");
        }

        if(age < 0 || age > 120){
            throw new ImpossibleAgeException(age);
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "LamdbaUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
