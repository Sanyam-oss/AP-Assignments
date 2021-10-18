package com.company;

public interface Assessment {

    void print_details();
    void print_grades(int id);

    boolean is_pending(int id);  // Tells if it's pending for student_id

    void take_submission(int id) throws Exception ;  // Accepts submission according to type

    boolean is_submitted(int id);
    boolean is_graded(int id);

    String getSubmission(int id);

    int[] show_submissions(int total_students) ;

    double getMaxmarks();

    void update_grades( double marks , int student_id , int grader_id );

    boolean is_open();

    void close();


}
