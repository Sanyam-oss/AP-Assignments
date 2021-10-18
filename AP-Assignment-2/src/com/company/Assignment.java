package com.company;

import java.util.*;
import java.io.*;

public class Assignment implements Assessment {

    private String problem;
    private double max_marks;
    private int instructor_id;
    private boolean status;
    private boolean[] submission_status;


    Assignment(String problem,double max_marks,int instructor_id){

        this.max_marks=max_marks;
        this.problem=problem;
        this.instructor_id=instructor_id;
        this.status=true;                                // Open assignment

        this.submission_status=new boolean[1000];

        // if submission_status[i]==false , i hasn't submitted
        // 1000 max_strength of classroom - assumption

    }
}
