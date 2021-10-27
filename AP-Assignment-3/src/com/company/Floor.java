package com.company;

public class Floor {

    private final int location;
    private final int score_awarded;

    Floor(int location,int score_awarded){

        this.location = location ;
        this.score_awarded = score_awarded ;
    }

    int getScore_awarded(){
        return this.score_awarded;
    }

    int getLocation(){ return this.location ; }

    int getNext_floor_position(){ return location ;}

    String type(){
      return "General Floor";
    }
}
