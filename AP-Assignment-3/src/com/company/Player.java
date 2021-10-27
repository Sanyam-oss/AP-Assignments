package com.company;

public class Player {

    private String Name ;
    private int points ;
    private int curr_position;
    // private Floor curr_floor ;

    Player(String Name) {

        this.Name = Name;
        this.points = 0;
        this.curr_position = -1;
        //this.curr_floor = null ;
    }

    int getCurr_position(){
        return curr_position;
    }

    void setCurr_position(int pos){

        if(pos>13 || pos<0){ return ; }
        this.curr_position=pos;
    }

    String getName(){
        return this.Name;
    }
}
