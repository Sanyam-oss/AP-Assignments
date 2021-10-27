package com.company;

import java.util.Random;

public class Dice {

    private int num_face;
    private int face_value;
    private static Random rand = new Random();

    Dice(int num_face){
        this.num_face = num_face;
    }

    void roll(){
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

    public int getFace_value(){
        return this.face_value;
    }

    public void setNum_face(int x){
        if(x > 0){  this.num_face=x ; }
    }
}
