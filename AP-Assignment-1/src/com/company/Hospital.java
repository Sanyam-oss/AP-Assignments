package com.company;

import java.util.ArrayList;

public class Hospital {

    String name ;
    int Pincode ;
    int Hospital_id;
    private ArrayList<Slot> Slots_filled = new ArrayList<Slot>();

    Hospital(String name,int Pincode,int Hospital_id){

        this.name = name;
        this.Pincode = Pincode;
        this.Hospital_id = Hospital_id;
    }

    void print_details(){
        System.out.println("Hospital Name: "+name+" , Pincode: "+Pincode+" , Unique Id: "+Hospital_id);
    }

    void add_slot(Slot slot){
        Slots_filled.add(slot);
    }

    void print_slots(){

        if(Slots_filled.size()==0){
            System.out.println("No Slots added for given Hospital"); return ;}

        for(int i=0;i<Slots_filled.size();i++){

            Slot slot = Slots_filled.get(i);
            System.out.println("Day: "+slot.getDay()+" | Vaccine: "+slot.getVaccine().getName()+" | Available Qty :"+slot.getQty());
        }
    }

    boolean is_equal(Hospital x){

        if(x.name.equals(this.name) && x.Pincode==this.Pincode){
            return true; }

        return false;
    }
}
