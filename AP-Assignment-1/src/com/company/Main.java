package com.company;

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        Cowin cowin = new Cowin();
        System.out.println( "Cowin Portal initialised...");

        while(true){

            cowin.display_menu();

            int query = sc.nextInt();

            if(query==1){
                cowin.Register_Vaccine();
            }

            if(query==2){
                cowin.Register_Hospital();
            }

            if(query==3){
                cowin.Register_citizen();
            }

            if(query==4){
                cowin.Enter_Slots();
            }

            if(query==5){
               cowin.book_slot();
            }

            if(query==6){
                cowin.search_slots_by_hospital();
            }

            if(query==7){
                cowin.check_Vaccination_status();
            }

            if(query==8){ break; }
        }
    }
}


