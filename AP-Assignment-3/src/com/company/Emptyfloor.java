package com.company;

public class Emptyfloor extends Floor {

    Emptyfloor() {
        super(1);
    }

    @Override
    String type(){
        return "Empty" ;
    }

    @Override
    boolean isEmpty(){ return true ;}
}
