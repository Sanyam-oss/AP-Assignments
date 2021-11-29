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

    void print_toys(){

        if (bucket.size()==0){
            System.out.println("No Toys , Empty bucket");
            return;
        }

        for (Toy toy : bucket) {
            System.out.print(toy.getName() + " ");
        }
        System.out.println();
    }
}
