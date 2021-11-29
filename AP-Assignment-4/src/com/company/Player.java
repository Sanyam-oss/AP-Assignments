package com.company;

public class Player {

    private final Bucket bucket ;

    Player(){
       this.bucket = new Bucket();
    }

    void add_Toy(Toy toy){
        this.bucket.addToy(toy);
    }

    void display_bucket(){

        try{
            bucket.print_toys();
        }
        catch (NoToyException e){
            System.out.println(e.getMessage());
        }
    }

    Bucket getBucket(){
        return this.bucket;
    }
}
