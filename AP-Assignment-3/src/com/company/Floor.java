package com.company;

public class Floor {

    private static int levels_added = 0 ;   // By removing this static we can pass location as parameter in constructor
    private final int location;
    private final int score_awarded ;

    Floor(int score_awarded){

        this.location = levels_added++ ;
        this.score_awarded = score_awarded ;
    }

    protected int getScore_awarded(){
        return this.score_awarded;
    }

    protected int getLocation(){ return this.location; }

    protected int getNext_floor_position(){ return location ;}

    boolean isEmpty(){ return false ;}

    String type(){
      return "General Empty";
    }
}
