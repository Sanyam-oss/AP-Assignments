package com.company;
import java.util.*;

public class Instructor implements User {

    private static int id;

    Instructor(){
        this.id = id ;
        id++;
    }

    int getId(){
        return this.id;
    }

}
