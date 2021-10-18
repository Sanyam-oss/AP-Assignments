package com.company;

public class Citizen {

    int Age ;
    String Name;
    String Id;
    Vaccine vaccine_taken;
    int no_of_doses_taken;
    int due_date;

    Citizen(int Age,String Name,String Id){

        this.Age=Age;
        this.Id=Id;
        this.Name=Name;
        this.no_of_doses_taken=0;
        this.due_date=0;
        this.vaccine_taken=null;          // Association
    }

    void print_details(){
        System.out.println("Citizen Name: "+this.Name+", Age: "+this.Age+", Unique Id: "+this.Id);
    }

    String getName(){return this.Name;}
    String getId(){
        return this.Id ;
    }
    Vaccine getVaccine_taken(){ return this.vaccine_taken ;}
    int getDue_date(){ return this.due_date ;}
    int getNo_of_doses_taken(){ return this.no_of_doses_taken ;}

    int getVaccinationStatus(){

        if(vaccine_taken==null){ return 0; }
        else if(no_of_doses_taken < vaccine_taken.getDoses()){ return 1 ; }
        return 2;
    }

    void setVaccine_taken(Vaccine vaccine){
        this.vaccine_taken=vaccine;
    }   // Association

    void setNo_of_doses_taken(int x){
        this.no_of_doses_taken=x;
    }

    void setDue_date(int x){
        this.due_date=x;
    }
}

// 0 : Registered
// 1 : Partially vaccinated
// 2 : Fully vaccinated

// Encapsulation
