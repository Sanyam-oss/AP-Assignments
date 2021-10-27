package com.company;

public class Ladderfloor extends Filledfloor {

    Ladderfloor(int location) {
        super(location,2,12);
    }

    @Override
    String type(){
        return "Ladder" ;
    }
}
