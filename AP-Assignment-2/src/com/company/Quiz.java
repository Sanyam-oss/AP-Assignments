package com.company;

public class Quiz implements Assessment {

    private String question ;
    private double max_marks;
    private int instructor_id;
    private boolean status;
    private boolean[] submission_status;

    Quiz(String ques ,int instructor_id){

        this.max_marks = 1.0;
        this.question = ques;
        this.instructor_id = instructor_id;
        this.status = true;                                // Open assignment
        this.submission_status = new boolean[1000];
    }
}
