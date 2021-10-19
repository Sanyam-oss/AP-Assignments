package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Reader.init(System.in);

        Backpack classroom = new Backpack();

        while(true){

            classroom.display_menu();
            int query = Reader.nextint();

            if(query==1){
                classroom.add_course();}

            if(query==2){
                classroom.add_Instructor();}

            if(query==3){
                classroom.add_Student();}

            if(query==4){

                classroom.login();
            }

            if(query==5){
                break;
            }

        }
    }
}
