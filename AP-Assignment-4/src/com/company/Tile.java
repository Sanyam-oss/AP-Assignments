package com.company;

public class Tile {

    private final Toy toy;

    Tile(String name){
        this.toy = new Toy(name);
    }

    public Toy getToy() {

        Toy copy = this.toy.clone();
        return copy;
    }
}
