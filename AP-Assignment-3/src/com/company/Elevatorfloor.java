package com.company;

public class Elevatorfloor extends Filledfloor{

    Elevatorfloor(int location) {
        super( location , 4 , 10 );
    }

    @Override
    String type(){
        return "Elevator" ;
    }
}
