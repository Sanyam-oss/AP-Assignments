package com.company;

public class Tile {

    private final Toy toy;

    public Tile(String name){
        this.toy = new Toy(name);
    }

    public Tile() {
        this.toy = null ;
    }

    public Toy getToy() throws NoToyException {

        if(toy==null){
            throw new NullPointerException("No Toy Present on this Tile");   // Can be thrown if new tile is created with default constructor
        }

        Toy copy = this.toy.clone();

        if(copy == null){
            throw new NoToyException("Toy Copy can't be created");
        }
        return copy;
    }
}
