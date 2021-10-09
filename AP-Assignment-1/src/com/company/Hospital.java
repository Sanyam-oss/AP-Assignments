package com.company;

public class Hospital {

    String name ;
    int Pincode ;
    int Hospital_id;

    Hospital(String name,int Pincode,int Hospital_id){

        this.name = name;
        this.Pincode = Pincode;
        this.Hospital_id = Hospital_id;
    }

    void print_details(){
        System.out.println("Hospital Name: "+name+" , Pincode: "+Pincode+" , Unique Id: "+Hospital_id);
    }

    boolean is_equal(Hospital x){

        if(x.name.equals(this.name) && x.Pincode==this.Pincode){
            return true; }

        return false;
    }
}
