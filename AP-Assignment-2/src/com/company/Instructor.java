package com.company;

public class Instructor implements User {

    private static int instructors = 0 ;
    private final int id ;

    Instructor(){
        this.id = instructors ;
        instructors++;
    }

    @Override
    public void print_role(){
        System.out.println("Instructor_"+this.id);
    }
}
