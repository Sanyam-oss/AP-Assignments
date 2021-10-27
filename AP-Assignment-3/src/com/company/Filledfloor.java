package com.company;

public class Filledfloor extends Floor{

    private final int next_floor_position;

    Filledfloor(int score_awarded,int next_floor_position) {
        super(score_awarded);
        this.next_floor_position=next_floor_position;
    }

    @Override
    protected int getNext_floor_position(){
        return this.next_floor_position;
    }
}
