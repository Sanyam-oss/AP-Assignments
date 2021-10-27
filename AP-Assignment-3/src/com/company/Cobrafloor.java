package com.company;

public class Cobrafloor extends Filledfloor{

    Cobrafloor(int location) {

        super(location, -4 , 3);
    }

    @Override
    String type(){
        return "King Cobra" ;
    }
}
