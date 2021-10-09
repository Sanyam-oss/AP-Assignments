package com.company;

public class Citizen {

    int Age ;
    String vaccine_status ;
    String Name;
    String Id;

    Citizen(int Age,String Name,String Id){
        this.Age=Age;
        this.Id=Id;
        this.Name=Name;
        this.vaccine_status="REGISTERED";
    }

    void print_details(){
        System.out.println("Citizen Name: "+this.Name+", Age: "+this.Age+", Unique Id: "+this.Id);
    }

    String getId(){
        return Id ;
    }
}

// 0 : Unregistered
// 1 : Registered
