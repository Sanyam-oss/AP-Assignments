package com.company;

public class Ladderfloor extends Filledfloor {

    Ladderfloor() {
        super(2,12);
    }

    @Override
    String type(){
        return "Ladder" ;
    }
}
