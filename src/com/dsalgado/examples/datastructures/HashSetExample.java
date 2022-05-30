package com.dsalgado.examples.datastructures;

import java.util.Set;

public class HashSetExample {

    private Set<String> hashSet;

    public HashSetExample(Set<String> hs){
        this.hashSet = hs;
    }

    public void addElement(String element){

        if (element.isEmpty()){
            throw new RuntimeException("String can't be empty");
        }

        this.hashSet.add(element);
    }

    public Set<String> getHashSet(){
        return this.hashSet;
    }

}
