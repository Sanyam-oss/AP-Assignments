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

                System.out.print("Vaccine Name: ");
                String name = sc.nextLine();
                System.out.print("Number of Doses: ");
                int doses = sc.nextInt();
                if(doses<=0){
                    System.out.println("Invalid Input for required field");}
                else if(doses==1){
                    cowin.add_Vaccine(name,doses,0); }
                else {
                    System.out.print("Gap between Doses: ");
                    int gap = sc.nextInt();
                    if (gap < 1) {
                        System.out.println("Invalid Input for required field");
                    } else {
                        cowin.add_Vaccine(name, doses, gap);
                    }
                }
            }

            if(query==8){ break;}


        }



    }

}


