package com.company;

import java.util.*;

public class Quiz implements Assessment {

    private String question ;
    private double max_marks;
    private int instructor_id;
    private boolean status;
    private boolean[] submission_status;
    private String[] submissions;
    private int[] Grades;
    private int[] Grader;

    Quiz(String ques ,int instructor_id){

        this.max_marks = 1.0;
        this.question = ques;
        this.instructor_id = instructor_id;
        this.status = true;                                // Open assignment
        this.submissions = new String[1000];
        this.submission_status = new boolean[1000];
        this.Grader = new int[1000];
        this.Grades = new int[1000];
        Arrays.fill(Grades,-1);
    }

    @Override
    public void print_details(){
        System.out.println(" Question : "+question);
        System.out.println("------------------------------------------------------------------");
    }

    @Override
    public void print_grades(int id){
        System.out.println(" Submission : " + submissions[id] );
        System.out.println(" Marks scored : " + Grades[id] );
        System.out.println(" Graded by : Instructor_" + Grader[id] );
        System.out.println("------------------------------------------------------------------");
    }

    @Override
    public boolean is_pending(int id){
        return (this.status==true && (!this.submission_status[id]));
    }

    @Override
    public void take_submission(int id) throws Exception{

        System.out.print(this.question + " : ");
        this.submissions[id] = Reader.reader.readLine();
        this.submission_status[id]=true;
    }

    @Override
    public boolean is_submitted(int id){
        return this.submission_status[id];
    }

    @Override
    public boolean is_graded(int id){
        return this.Grades[id]!=-1 ;
    }

    @Override
    public String getSubmission(int id){
        return submissions[id];
    }
}
