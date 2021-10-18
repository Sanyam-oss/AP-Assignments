package com.company;

import java.util.*;
import java.io.*;

public class Assignment implements Assessment {

    private String problem;
    private double max_marks;
    private int instructor_id;
    private boolean status;
    private boolean[] submission_status;
    private String[] submissions;
    private int[] Grades;
    private int[] Grader;


    Assignment(String problem,double max_marks,int instructor_id){

        this.max_marks=max_marks;
        this.problem=problem;
        this.instructor_id=instructor_id;
        this.status=true;                                // Open assignment

        this.submission_status=new boolean[1000];
        this.submissions = new String[1000];
        this.Grader = new int[1000];
        this.Grades = new int[1000];                 // In our case 3 is enough
        Arrays.fill(Grades,-1);

        // if submission_status[i]==false , i hasn't submitted
        // 1000 max_strength of classroom - assumption

    }

    @Override
    public void print_details(){
        System.out.println(" Assignment : "+ this.problem + " | Max. marks : " + this.max_marks );
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

        System.out.print( " Enter Filename of Assignment : ");
        String filename = Reader.reader.readLine();

        int n = filename.length();

        if((n>=4) && (filename.substring(n-4)).equals(".zip")){
            this.submissions[id] = filename;
            this.submission_status[id]=true;
            return;
        }

        System.out.println("Invalid file type - must be .zip format ");
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
