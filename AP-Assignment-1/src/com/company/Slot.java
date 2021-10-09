package com.company;

public class Slot {

    int hospital_id;
    int day ;
    int qty;
    Vaccine vaccine;

    Slot(int hospital_id , int day,int qty,Vaccine vaccine){
        this.hospital_id = hospital_id;
        this.day = day ;
        this.qty = qty ;
        this.vaccine = vaccine;
    }

    void print_details(){
        System.out.println("Slot added by Hospital "+this.hospital_id+" for Day: "+this.day);
        System.out.println("Availabele Quantity: "+this.qty+" of Vaccine "+this.vaccine.getName());
    }

}
