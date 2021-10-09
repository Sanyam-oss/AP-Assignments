package com.company;

public class Vaccine {

    private String name;
    private int doses;
    private int gap;

    Vaccine( String name , int doses , int gap ){
        this.name = name;
        this.doses = doses;
        this.gap = gap;
    }

    void print_details(){
        System.out.println("Vaccine Name: "+name+" , Number of Doses: "+doses+" , Gap between Doses: "+gap);
    }

    boolean is_equal(Vaccine x){

        if((x.name.equals(this.name)) && (x.doses==this.doses) && (x.gap==this.gap)){
            return true;
        }
        return false;
    }

    String getName(){
        return this.name;
    }


}
