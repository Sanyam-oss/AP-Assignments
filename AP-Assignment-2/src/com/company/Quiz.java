package com.company;

import java.util.*;

public class Quiz implements Assessment {

    private final String question ;
    private final double max_marks;
    private final int instructor_id;
    private boolean status;
    private final boolean[] submission_status;
    private final String[] submissions;
    private final double[] Grades;
    private final int[] Grader;

    Quiz(String ques ,int instructor_id){

        this.max_marks = 1.0;
        this.question = ques;
        this.instructor_id = instructor_id;
        this.status = true;                                // Open assignment
        this.submissions = new String[1000];
        this.submission_status = new boolean[1000];
        this.Grader = new int[1000];
        this.Grades = new double[1000];
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
        return (this.status && (!this.submission_status[id]));
    }

    @Override
    public void take_submission(int id) throws Exception{

        System.out.print(this.question + " : ");
        this.submissions[id] = Reader.reader.readLine();
        this.submission_status[id]=true;
    }

    @Override
    public int[] show_submissions(int students){

        int[] To_be_graded = new int[students];

        int index = 0 ;
        boolean x = false ;

        for(int i=0 ; i<students ; i++){

            if(submission_status[i]){

                if(Grades[i]==-1) {
                    System.out.println(index + ". Student_" + i);
                    To_be_graded[index] = i;
                    index++;
                }
                x = true;
            }
        }

        if(index==0 && (x) ){
            System.out.println("All Assignments graded for this Assessment , Ahead of your time :) ");
            return null;
        }

        else if(index == 0 && (!x)){
            System.out.println("No Submissions done for this assessment ");
            return null;
        }

        return To_be_graded;
    }

    @Override
    public void update_grades(double marks , int student_id , int instructor_id){

        Grades[student_id]=marks;
        Grader[student_id]=instructor_id;
    }

    @Override
    public void close(){
        this.status=false;
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

    @Override
    public double getMaxmarks(){
        return this.max_marks;
    }

    @Override
    public boolean is_open(){
        return this.status;
    }


}
