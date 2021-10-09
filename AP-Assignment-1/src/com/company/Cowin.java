package com.company;

import java.util.*;

public class Cowin {

    private static int hospital_id ;
    private ArrayList<Vaccine> Vaccines_record = new ArrayList<Vaccine>();
    private ArrayList<Hospital> Hospital_record = new ArrayList<Hospital>();
    private ArrayList<Slot> Slots_Available = new ArrayList<Slot>();

    Cowin(){

        hospital_id = 100000;

    }

    void Enter_Slots(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Hospital ID: ");
        int id = sc.nextInt();

        if(id<100000 || id>=hospital_id){
            System.out.println("Not Valid Id");
            return;
        }

        System.out.print("Enter Number of Slots to be added: ");
        int num = sc.nextInt();

        for(int i=0;i<num;i++){

            System.out.print("Enter Day Number: ");
            int day = sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            System.out.println("Select Vaccine: ");

            for(int j = 0 ; j < Vaccines_record.size();j++){

                System.out.println(j+"."+Vaccines_record.get(j).getName());
            }

            int vaccine_ind = sc.nextInt();
            if(vaccine_ind>= Vaccines_record.size()){
                System.out.println("Invalid Vaccine Code");
                return;
            }
            add_Slot(id,day,qty,vaccine_ind);
        }
    }

    void add_Slot(int id ,int day,int qty,int vaccine_ind){

        Slot slot = new Slot(id,day,qty,Vaccines_record.get(vaccine_ind));
        Slots_Available.add(slot);
        slot.print_details();
    }

    void Register_Vaccine(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Vaccine Name: ");
        String name = sc.nextLine();
        System.out.print("Number of Doses: ");
        int doses = sc.nextInt();
        if(doses<=0){
            System.out.println("Invalid Input for required field");}
        else if(doses==1){
            add_Vaccine(name,doses,0); }
        else {
            System.out.print("Gap between Doses: ");
            int gap = sc.nextInt();
            if (gap < 1) {
                System.out.println("Invalid Input for required field");
            } else {
                add_Vaccine(name, doses, gap);
            }
        }
    }

    void add_Vaccine(String name,int doses,int gap){

        Vaccine vaccine = new Vaccine(name,doses,gap);

        if(!Is_Vaccine_present(vaccine)) {
            Vaccines_record.add(vaccine);
            vaccine.print_details();
        }

        else {
            System.out.println("Vaccine already Registered");
        }
    }

    void Register_Hospital(){

        Scanner sc= new Scanner(System.in);

        System.out.print("Hospital Name: ");
        String name = sc.nextLine();
        System.out.print("Pincode: ");
        int pincode = sc.nextInt();

        if(pincode<0){
            System.out.println("Invalid Pincode");}

        else{
            add_Hospital(name,pincode);
        }
    }

    void add_Hospital(String name,int pincode){

        Hospital hospital = new Hospital(name,pincode,hospital_id);

        if(!Is_Hospital_registered(hospital)) {
            Hospital_record.add(hospital);
            hospital.print_details();
            hospital_id++;
        }
        else {
            System.out.println("Hospital already registered");
        }
    }

    boolean Is_Vaccine_present(Vaccine vaccine){

        int vaccine_record_size = Vaccines_record.size();

        for(int i=0 ; i < vaccine_record_size ; i++ ){

            if(vaccine.is_equal(Vaccines_record.get(i))){
                return true;
            }
        }
        return false;
    }

    boolean Is_Hospital_registered(Hospital hospital){

        int hospital_record_size = Hospital_record.size();

        for(int i=0 ; i < hospital_record_size ; i++ ){

            if(hospital.is_equal(Hospital_record.get(i))){
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
