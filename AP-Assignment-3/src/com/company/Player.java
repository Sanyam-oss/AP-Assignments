package com.company;

public class Player {

    private final String Name ;
    private int curr_position;

    Player(String Name, int curr_position) {

        this.Name = Name;
        this.curr_position = curr_position;
    }

    int getCurr_position(){
        return curr_position;
    }

    void setCurr_position(int pos , int last_pos ){

        if(pos > last_pos || pos < 0){ return ; }
        this.curr_position = pos ;
    }

    String getName(){
        return this.Name;
    }
}
