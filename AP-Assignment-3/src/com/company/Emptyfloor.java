package com.company;

public class Emptyfloor extends Floor {


    Emptyfloor(int location) {
        super(location, 1);
    }

    @Override
    String type(){
        return "Empty" ;
    }
}
