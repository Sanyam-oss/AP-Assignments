package com.company;
import java.util.*;

public class Instructor implements User {

    private static int instructors = 0 ;
    private int id ;

    Instructor(){
        this.id = instructors ;
        instructors++;
    }

    @Override
    public void print_role(){
        System.out.println("Instructor_"+this.id);
    }
}
