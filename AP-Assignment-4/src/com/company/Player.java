package com.company;

public class Player {

    private final Bucket bucket ;

    Player(){
       this.bucket = new Bucket();
    }

    Bucket getBucket(){
        return this.bucket;
    }

    void add_Toy(Toy toy){
        this.bucket.addToy(toy);
    }

    void display_bucket(){
        bucket.print_toys();
    }




}
