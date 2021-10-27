package com.company;

public class Player {

    private final String Name ;
    private int curr_position;
//     private int points ;
//     private Floor curr_floor ;

    Player(String Name) {

        this.Name = Name;
        this.curr_position = -1;
        // this.points = 0;
        // this.curr_floor = null ;
    }

    int getCurr_position(){
        return curr_position;
    }

    void setCurr_position(int pos , int last_pos){

        if(pos>last_pos || pos<0){ return ; }
        this.curr_position=pos;
    }

    String getName(){
        return this.Name;
    }
}
