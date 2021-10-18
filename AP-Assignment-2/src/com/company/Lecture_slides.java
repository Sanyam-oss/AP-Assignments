package com.company;

import java.util.*;

public class Lecture_slides implements Material {

    private final String Topic;
    private final int Number_of_slides;
    private final String[] Contents;
    private final int instructor_id;
    private final Date Upload_Date;

    Lecture_slides(String topic , String[] contents , int instructor_id , Date upload_date ){
        this.Topic = topic;
        this.instructor_id=instructor_id;
        this.Number_of_slides=contents.length;
        this.Upload_Date=upload_date;
        this.Contents = contents;
    }

    @Override
    public void print_details(){

        System.out.println("Title : " + this.Topic );

        for(int i=0;i<Contents.length;i++){
            System.out.println("Slide "+(i+1)+": "+Contents[i]);
        }

        System.out.println("Number of Slides : "+Number_of_slides);

        String date = String.format("%tc", this.Upload_Date );
        System.out.println("Date of Upload : "+date);
        System.out.println("Uploaded by : Instructor_"+this.instructor_id);
        System.out.println("------------------------------------------------------------------");
    }
}
