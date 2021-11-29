package com.company;

import java.util.*;

public class Bucket {

    private final ArrayList<Toy> bucket ;

    Bucket(){
        this.bucket = new ArrayList<>();
    }

    void addToy(Toy toy){

        if(toy!=null){                           // Exception
            bucket.add(toy);
        }
    }

    void print_toys() throws NoToyException{

        if (bucket.size()==0){
            throw new NoToyException("No Toys , Empty Bucket");
        }

        for (Toy toy : bucket) {
            System.out.println(toy.getName() + " ");
        }
    }
}
