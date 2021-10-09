package com.company;

import java.util.*;

public class Cowin {

    private ArrayList<Vaccine> Vaccines_record = new ArrayList<Vaccine>();


    void add_Vaccine(String name,int doses,int gap){

        Vaccine vaccine = new Vaccine(name,doses,gap);

        if(!Is_Vaccine_present(vaccine)){
            Vaccines_record.add(vaccine);
            vaccine.print_details();
        }
        else{
            System.out.println("This Vaccine is already addded to the records");
        }

    }

    boolean Is_Vaccine_present(Vaccine vaccine){

        int vaccine_record_size = Vaccines_record.size();

        for(int i=0 ; i < vaccine_record_size ; i++ ){

            if(vaccine.equals(Vaccines_record.get(i))){
                return true;
            }
        }
        return false;
    }


    void display_menu(){
        System.out.println("--------------------------------------------");
        System.out.println("1.Add Vaccine");
        System.out.println("2.Register Hospital");
        System.out.println("3.Register Citizen");
        System.out.println("4.Add Slot for Vaccination");
        System.out.println("5.Book Slot for Vaccination");
        System.out.println("6.List all slots for a Hospital");
        System.out.println("7.Check Vaccination Status");
        System.out.println("8.Exit");
        System.out.println("--------------------------------------------");
    }
}
