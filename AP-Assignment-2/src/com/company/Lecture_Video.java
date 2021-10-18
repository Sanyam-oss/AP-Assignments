package com.company;
import java.util.*;

public class Lecture_Video implements Material {

    private String Filename;
    private String Topic;
    private int instructor_id;
    private Date Upload_Date;

    Lecture_Video(String topic , String Filename , int instructor_id , Date Upload_Date ){

        this.Filename = Filename;
        this.Topic = topic;
        this.Upload_Date = Upload_Date;
        this.instructor_id = instructor_id;
    }

    @Override
    public void print_details(){

        System.out.println("Title of Video : "+this.Topic);
        System.out.println("Filename : "+this.Filename);
        String date = String.format("%tc", this.Upload_Date );
        System.out.println("Date of Upload : "+date);
        System.out.println("Uploaded by : Instructor_"+this.instructor_id);
        System.out.println("------------------------------------------------------------------");
    }
}
