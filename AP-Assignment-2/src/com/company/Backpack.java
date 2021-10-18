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

            if ( choice == 1 ) {
                add_class_Material(course, instructor_id);
            }

            if ( choice == 2 ) {
                add_Assessments(course, instructor_id);
            }

            if ( choice == 3 ){
                course.show_material();
            }

            if( choice == 4 ){
                course.show_Assessments();
            }

            if( choice==5 ){
                grade_assessments(course , instructor_id);
            }

            if( choice==6 ){
                close_assessment(course);
            }

            if ( choice==7 ){
                course.show_course_comments();
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

            if (choice == 2) {
                course.show_Assessments();
            }

            if( choice==3 ){
                submit_assessments(course,student_id);
            }

            if( choice==4 ){
                View_grades(course,student_id);
            }

            if (choice==5 ){
                course.show_course_comments();
            }

            if(choice==6){
                Student student = course.getStudents_List().get(student_id);
                add_comments(course,student);
            }

            if(choice==7){
                break;
            }
        }


    }

    void grade_assessments(Course course , int instructor_id) throws Exception{

        course.show_Assessments();

        System.out.print("Enter ID of Assessment to view submissions : ");
        int assessment_id = Reader.nextint();

        Assessment assessment = course.getAssessment(assessment_id);

        System.out.println("Choose from below Ungraded Submissions : ");
        int[] util = assessment.show_submissions(course.getStudents_List().size());

        if(util==null){ return ; }

        int ind  = Reader.nextint();

        System.out.println("Submission : "+ assessment.getSubmission(util[ind]));
        System.out.println("---------------------------------------------------------");

        System.out.println("Max Marks : "+ assessment.getMaxmarks());
        System.out.print("Enter Marks Scored : ");

        double marks = Reader.nextdouble();

        if( marks > assessment.getMaxmarks()){
            System.out.println("Thanks for the kindness but Marks scored must be <= Max.marks");
            return;
        }

        assessment.update_grades(marks , util[ind] , instructor_id );
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

            else{System.out.println("Invalid File type - must be .mp4 format ");}
        }
    }

    void add_Assessments( Course course , int instructor_id ) throws Exception {

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

    void close_assessment(Course course) throws Exception{

        ArrayList<Assessment>open_assessments = course.Open_assessments();
        System.out.print("Enter ID to be closed : ");
        int ind = Reader.nextint();
        Assessment assessment = open_assessments.get(ind);
        assessment.close();
    }

    void submit_assessments(  Course course , int student_id ) throws Exception{

        ArrayList<Assessment>assessments = course.Pending_assessments(student_id);

        if(assessments.size()==0){
            System.out.println("No pending Assignments , Hurray :) ");
            return;
        }

        System.out.print("Enter Id of Assessment : ");

        int assessment_id = Reader.nextint();
        Assessment assessment = assessments.get(assessment_id);
        assessment.take_submission(student_id);
    }

    void View_grades(Course course , int student_id ){

        System.out.println("GRADED ASSESSMENTS ");
        course.Graded_assessments(student_id);
        System.out.println();
        System.out.println("UNGRADED ASSESSMENTS ");
        course.Ungraded_assessments(student_id);
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
        if((n>=4) && (name.substring(n-4)).equals(".mp4")) return true;  // .mp4 only is valid also
        return false;
    }

    void display_menu(){

        System.out.println("WELCOME TO BACKPACK !!!");
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
