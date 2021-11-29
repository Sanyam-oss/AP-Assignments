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

        } catch (CloneNotSupportedException e) {

            return null;       // Null pointer check , though won't happen ever since implements Cloneable interface
        }
    }

    String getName(){
        return this.name;
    }
}
