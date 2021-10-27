package com.company;

import java.util.Random;

public class Dice {

    private final int num_face;
    private int face_value;

    Dice(){
        num_face = 3;
    }

    void roll(){
        Random rand = new Random();
        int curr_num = 1+rand.nextInt(num_face);
        this.setFace_value(curr_num);
    }

    private void setFace_value(int num){

        if(num<=num_face) {
            face_value = num;
            System.out.println("Dice gave " + this.face_value);
            return;
        }

        System.out.println("Invalid Number on Roll");
    }

    int getFace_value(){
        return this.face_value;
    }
}
