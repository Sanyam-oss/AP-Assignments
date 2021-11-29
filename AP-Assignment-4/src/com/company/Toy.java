package com.company;

public class Toy implements Cloneable {

    private final String name;

    Toy(String name){
        this.name = name ;
    }

    public Toy clone(){

        try{

            Toy copy = (Toy)super.clone();
            return copy;

        } catch (CloneNotSupportedException e) {  // Won't even happen since implements CLoneable Interface

            return null;                          // Null pointer check

        }
    }

    String getName(){
        return this.name;
    }
}
