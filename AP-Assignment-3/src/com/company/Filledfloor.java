package com.company;

public class Filledfloor extends Floor{

    private final int next_floor_position;

    Filledfloor(int location, int score_awarded,int next_floor_position) {
        super(location, score_awarded);
        this.next_floor_position=next_floor_position;
    }

    @Override
    int getNext_floor_position(){
        return this.next_floor_position;
    }
}
