package com.company;
import java.util.*;

public class Backpack {

    private final ArrayList<Course>courses;    // Assuming multiple courses can be there

    Backpack(){
        courses = new ArrayList<>();
    }

    void Instructor_login(Course course) throws Exception{

        course.display_Instructors();
        System.out.print("Choose Id: ");
        int instructor_id = Reader.nextint();

        while(true) {

            System.out.println("Welcome Instructor_" + instructor_id);
            display_Instructor_menu();

            int choice = Reader.nextint();

            if (choice == 1) {
                add_class_Material(course, instructor_id);
            }

            if (choice == 2) {
                add_Assessments(course, instructor_id);
            }

            if( choice == 8){
                Instructor instructor = course.getInstructors_List().get(instructor_id);
                add_comments(course,instructor);
            }

            if(choice==9){
                break;
            }


        }

    }

    void Student_login(Course course) throws Exception{

        course.display_Students();
        System.out.print("Choose Id: ");
        int student_id = Reader.nextint();

        while(true) {

            System.out.println("Welcome Student_" + student_id);
            display_Student_menu();

            int choice = Reader.nextint();

            if (choice == 1) {
                course.show_material();
            }

//            if (choice == 2) {
//                add_Assessments(course, instructor_id);
//            }
//
//            if( choice == 8){
//                Instructor instructor = course.getInstructors_List().get(instructor_id);
//                add_comments(course,instructor);
//            }
//
            if(choice==7){
                break;
            }
        }


    }

    void add_class_Material(Course course , int instructor_id ) throws Exception{

        System.out.println("1. Add Lecture Slide ");
        System.out.println("2. Add Lecture Video ");

        int query = Reader.nextint();

        if(query==1){

            System.out.print("Enter Slide Topic: ");
            String topic = Reader.reader.readLine();

            System.out.print("Enter Number of Slides: ");
            int n = Reader.nextint();

            String[] content = new String[n] ;
            System.out.println("Contents of Slides");
            for( int i=1 ; i<=n ; i++ ){
                System.out.print("Content of Slide "+i+" : ");
                content[i-1]=Reader.reader.readLine();
            }

            Date upload_date = new Date();
            course.add_lecture_slides(topic,content,instructor_id,upload_date);
        }

        else if(query==2){

            System.out.print("Enter Topic of Video : ");
            String topic = Reader.reader.readLine();

            System.out.print("Enter Filename of Video : ");
            String Filename = Reader.reader.readLine() ;

            if(is_Valid_name(Filename)){

                Date upload_date = new Date();
                course.add_lecture_video(topic,Filename,instructor_id,upload_date);}

            else{System.out.println("Invalid File type");}
        }
    }

    void add_Assessments(Course course , int instructor_id ) throws Exception {

        System.out.println("1. Add Assignment ");
        System.out.println("2. Add Quiz ");

        int query = Reader.nextint();

        if(query==1){

            System.out.print("Enter Assignment Problem Statement: ");
            String problem_statement = Reader.reader.readLine();

            System.out.print("Enter Max. marks: ");
            double max_marks = Reader.nextint();

            course.add_Assignment(problem_statement,max_marks,instructor_id);
        }

        else if(query==2){

            System.out.print("Enter Quiz question : ");
            String ques = Reader.reader.readLine();

            course.add_quiz(ques,instructor_id);
        }
    }

    void add_comments(Course course,User user) throws Exception{

        System.out.print("Enter Comment : ");
        String comment = Reader.reader.readLine();
        Date upload_date = new Date();

        course.add_comment(comment , user , upload_date );
    }

    void login() throws Exception {

        System.out.print("Enter Course Name: ");
        String course_name = Reader.reader.readLine();

        Course course = find_course(course_name);

        if(course==null){
            System.out.println("Course Not Registered");
            return;
        }

        while(true) {

            display_login_menu();

            int choice = Reader.nextint();

            if (choice == 1) {
                Instructor_login(course);}
            else if (choice == 2) {
                Student_login(course);}
            else {
                return;
            }
        }
    }

    void add_course() throws Exception {

        System.out.print("Enter Course Name: ");
        String Name = Reader.reader.readLine();

        Course course = new Course(Name);
        courses.add(course);
    }

    void add_Instructor() throws Exception{   // Course name where u want to add an instructor

        System.out.print("Enter Course Name: ");
        String course_name = Reader.reader.readLine();
        Course course = find_course(course_name);

        if(course==null){
            System.out.println("Course Not Registered");
            return;
        }

        course.add_Instructor();         // Can add attributes to Instructor like name,etc.
    }

    void add_Student() throws Exception{

        System.out.print("Enter Course Name: ");
        String course_name = Reader.reader.readLine();
        Course course = find_course(course_name);

        if(course==null){
            System.out.println("Course Not Registered");
            return;
        }

        course.add_student();         // Can add attributes to Student like name,etc.
    }

    Course find_course(String course_name){

        Course req_course = null ;

        for (Course course : courses) {

            if (course.getName().equals(course_name)) {
                req_course = course;
                break;
            }
        }

        return req_course;
    }

    boolean is_Valid_name(String name){

        int n = name.length();

        if((name.length()>4) && (name.substring(n-4)).equals(".mp4")) return true;
        return false;
    }

    void display_menu(){

        System.out.println("Welcome to Backpack");
        System.out.println("1. Add Course");
        System.out.println("2. Register Instructor");
        System.out.println("3. Register Student");
        System.out.println("4. Login");
        System.out.println("5. Exit");
    }

    void display_login_menu(){

        System.out.println("Welcome to Backpack");
        System.out.println("1. Enter as Instructor");
        System.out.println("2. Enter as Student");
        System.out.println("3. Exit");
    }

    void display_Instructor_menu(){

        System.out.println("1. Add Class Material");
        System.out.println("2. Add Assessments");
        System.out.println("3. View Lecture Materials");
        System.out.println("4. View Assessments");
        System.out.println("5. Grade Assessments");
        System.out.println("6. CLose Assessment");
        System.out.println("7. View Comments");
        System.out.println("8. Add Comments");
        System.out.println("9. Logout");
    }

    void display_Student_menu(){

        System.out.println("1. View Lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit Assessments");
        System.out.println("4. View Grades");
        System.out.println("5. View Comments");
        System.out.println("6. Add Comments");
        System.out.println("7. Logout");
    }
}

// instructor.view(this) in course page
