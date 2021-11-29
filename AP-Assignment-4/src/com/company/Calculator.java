package com.company;

public class Calculator <T> {

    public Calculator(){ }

    public boolean verify( T o1 , T o2 , String user_ans ){

        if(o1 instanceof Integer && o2 instanceof Integer){

            int correct_ans  ;

            try{  correct_ans = (int)o1/(int)o2 ; }

            catch(ArithmeticException e){ return user_ans.equals("X"); }

            String correct_ans_string = Integer.toString(correct_ans);
            return correct_ans_string.equals(user_ans);
        }

        else if(o1 instanceof String && o2 instanceof String){

            String correct_ans_string = (String)o1 + (String)o2 ;
            return correct_ans_string.equals(user_ans);
        }

        return false;

    }
}
