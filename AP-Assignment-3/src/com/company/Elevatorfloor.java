package com.company;

public class Elevatorfloor extends Filledfloor{

    Elevatorfloor() {
        super( 4 , 10 );
    }

    @Override
    String type(){
        return "Elevator" ;
    }
}
