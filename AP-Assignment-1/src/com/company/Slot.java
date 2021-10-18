package com.company;

public class Slot {

    private int hospital_id;
    private int day ;
    private int qty;
    private Vaccine vaccine;

    Slot(int hospital_id , int day,int qty,Vaccine vaccine){           // Association
        this.hospital_id = hospital_id;
        this.day = day ;
        this.qty = qty ;
        this.vaccine = vaccine;
    }

    void print_details(){
        System.out.println("Slot added by Hospital "+this.hospital_id+" for Day: "+this.day);
        System.out.println("Availabele Quantity: "+this.qty+" of Vaccine "+this.vaccine.getName());
    }

    int getHospital_id(){
        return hospital_id;
    }

    int getDay(){
        return day;
    }

    int getQty(){
        return qty;
    }

    void setQty(int x){ this.qty = x ;}

    Vaccine getVaccine(){
        return vaccine;
    }

}
