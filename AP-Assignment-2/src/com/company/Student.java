package com.company;
import java.util.*;

public class Student implements User {

    private static int students = 0 ;
    private int id ;

    Student(){

        this.id = students ;
        students++;
    }

    @Override
    public void print_role(){
        System.out.println("Student_"+this.id);
    }
}
