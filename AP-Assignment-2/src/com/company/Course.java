package com.company;
import java.util.*;

public class Course {

    private final String Name;
    private ArrayList<Instructor>Instructors_List;
    private ArrayList<Student>Students_List;
    private ArrayList<Material>Course_Materials;
    private ArrayList<Assessment>Course_Assessments;
    private ArrayList<Comment>Course_comments;

    Course(String Name){
        this.Name = Name;
        Instructors_List = new ArrayList<>();
        Students_List = new ArrayList<>();
        Course_Materials = new ArrayList<>();
        Course_Assessments = new ArrayList<>();
        Course_comments = new ArrayList<>();
    }

    void add_lecture_slides(String topic, String[]content , int instr_id , Date upload_date){

        Lecture_slides slide = new Lecture_slides(topic,content,instr_id,upload_date);  // Composition
        Course_Materials.add(slide);
    }

    void add_lecture_video(String topic , String Filename , int instructor_id , Date upload_date){

        Lecture_Video video = new Lecture_Video(topic , Filename , instructor_id , upload_date );
        Course_Materials.add(video);
    }

    void add_Assignment(String statement , double max_marks , int instructor_id ){

        Assignment assignment = new Assignment(statement,max_marks,instructor_id);
        Course_Assessments.add(assignment);
    }

    void add_quiz(String question , int instructor_id ){

        Quiz quiz = new Quiz(question,instructor_id);
        Course_Assessments.add(quiz);
    }

    void add_comment(String comm , User user , Date date ){

        Comment comment = new Comment(comm,user,date);
        Course_comments.add(comment);
    }

    void show_material(){

        for ( Material material : Course_Materials ) {
            material.print_details();
        }

    }

    void add_student(){
        Student student = new Student();
        Students_List.add(student);
    }

    void add_Instructor(){
        Instructor instructor = new Instructor();
        Instructors_List.add(instructor);
    }

    String getName(){
        return this.Name;
    }

    ArrayList<Instructor>getInstructors_List(){
        return this.Instructors_List;
    }

    ArrayList<Student>getStudents_List(){
        return this.Students_List;
    }

    void display_Instructors(){

        if(this.Instructors_List.size()==0){
            System.out.println("No Instructor Registered ");
            return;
        }

        for(int i=0;i<this.Instructors_List.size();i++){
            System.out.println( i+".Instructor_Id_"+i);
        }
    }

    void display_Students(){

        if(this.Students_List.size()==0){
            System.out.println("No Instructor Registered ");
            return;
        }

        for(int i=0;i<this.Students_List.size();i++){
            System.out.println( i+".Student_Id_"+i);
        }
    }
}
