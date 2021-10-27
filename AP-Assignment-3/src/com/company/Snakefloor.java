package com.company;

public class Snakefloor extends Filledfloor {

    Snakefloor(int location){
        super( location , -2 , 1 );
    }

    @Override
    String type(){
        return "Normal Snake" ;
    }
}
