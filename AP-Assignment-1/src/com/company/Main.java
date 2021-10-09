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
            sc.nextLine();

            if(query==1){
                cowin.Register_Vaccine();
            }

            if(query==2){
                cowin.Register_Hospital();
            }

            if(query==4){
                cowin.Enter_Slots();
            }

            if(query==8){ break;}


        }



    }

}


