package com.company;

public interface Assessment {

    void print_details();
    void print_grades(int id);

    boolean is_pending(int id);  // Tells if it's pending for student_id

    void take_submission(int id) throws Exception ;  // Accepts submission according to type

    boolean is_submitted(int id);
    boolean is_graded(int id);

    String getSubmission(int id);


}
