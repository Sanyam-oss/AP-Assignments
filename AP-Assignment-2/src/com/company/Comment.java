package com.company;

import java.util.*;

public class Comment {

    private final String Comment ;
    private final Date Upload_Date;
    private final User user;

    Comment(String comment , User user , Date date ){

        this.Comment=comment;
        this.Upload_Date=date;
        this.user = user;
    }

    public void print_comment(){

        System.out.print(this.Comment+" - ");
        this.user.print_role();
        String date = String.format("%tc", this.Upload_Date );
        System.out.println(date);
        System.out.println("---------------------------------------------");

    }
}
