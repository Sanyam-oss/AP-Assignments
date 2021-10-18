package com.company;

import java.util.*;

public class Comment {

    private String Comment ;
    private Date upload_date;
    private User user;

    Comment(String comment , User user , Date date ){

        this.Comment=comment;
        this.upload_date=date;
        this.user = user;

    }
}
