package com.company;

import java.io.IOException;
import java.util.*;
import java.lang.*;

public class Gameplay {

    private final ArrayList<Tile> Carpet ;
    private final int carpet_length;
    private final Player player;
    private Calculator calculator ;
    private Tile curr_tile;
    private int curr_pos;
    private final int last_tile;
    private int chance_num;
    private int max_chances;
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();

    Gameplay(){

        this.Carpet = new ArrayList<>(21);
        this.carpet_length = 20 ;
        this.player = new Player();
        this.calculator = new Calculator();
        this.curr_pos = 0 ;
        this.curr_tile = null ;
        this.set_carpet();
        this.last_tile = 20 ;
        this.max_chances = 5 ;
        this.chance_num = 0 ;
    }

    void set_carpet(){

        Carpet.add(new Tile());                    // To apply 1-based indexing and exception creation
        Carpet.add(new Tile("A"));
        Carpet.add(new Tile("B"));
        Carpet.add(new Tile("C"));
        Carpet.add(new Tile("D"));
        Carpet.add(new Tile("E"));
        Carpet.add(new Tile("F"));
        Carpet.add(new Tile("G"));
        Carpet.add(new Tile("H"));
        Carpet.add(new Tile("I"));
        Carpet.add(new Tile("J"));
        Carpet.add(new Tile("K"));
        Carpet.add(new Tile("L"));
        Carpet.add(new Tile("M"));
        Carpet.add(new Tile("N"));
        Carpet.add(new Tile("O"));
        Carpet.add(new Tile("P"));
        Carpet.add(new Tile("Q"));
        Carpet.add(new Tile("R"));
        Carpet.add(new Tile("S"));
        Carpet.add(new Tile("T"));

        System.out.println("Game is Ready !!!");
    }

    void play() throws IOException {

        while(chance_num < max_chances){

            print_line();
            System.out.print("Hit Enter for your "+helper(chance_num)+" hop!");
            scanner.nextLine();

            curr_pos = this.random_num_generator();

            boolean flag = false ;

            try{

                curr_tile = Carpet.get(curr_pos);                 // Array out of bound Exception

            }catch (IndexOutOfBoundsException e){

                System.out.println("Redbull gives you wings :)");
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash! ");
                chance_num++;
                flag = true ;
            }

            if(flag){ continue; }

            System.out.println( "You landed on Tile " + curr_pos );

            if((curr_pos & 1) == 0){

                Toy won_toy = null ;
                boolean exc = false ;

                try{
                    won_toy = curr_tile.getToy();                      // Check for null pointer (Clone issue)
                }

                catch(NoToyException e){

                    try{
                        won_toy = curr_tile.getToy();                  // REDO STEP

                    }catch (NoToyException ex){

                        System.out.println(ex.getMessage());
                        exc = true ;
                    }
                }

                if(exc){ chance_num++ ; continue ; }

                player.add_Toy(won_toy);
                System.out.println("You won a Toy " + won_toy.getName());
            }

            else{

                flag=true;
                String input = null ;

                while(flag) {

                    System.out.println("Question answer round. Integer or String? ");
                    String inp = Reader.next();
                    flag = false ;

                    try {

                        input = question_type(inp);

                    } catch (InvalidInputException e) {

                        System.out.println(e.getMessage());
                        flag = true;
                    }
                }

                boolean verdict = false ;

                if(input.equals("integer")){

                    int op1 = Number_generator();
                    int op2 = Number_generator();

                    System.out.println("Calculate the result of "+op1+" divided by "+op2+ " [ (U) if undefined ] ");

                    String user_ans = Reader.next();

                    verdict = calculator.verify(op1,op2,user_ans);
                }

                if(input.equals("string")){

                    int len = 1+rand.nextInt(6);
                    String op1 = String_generator(len);
                    String op2 = String_generator(len);

                    System.out.println("Calculate the concatenation of strings " +op1+" and "+op2);

                    String user_ans = Reader.next();

                    verdict = calculator.verify(op1,op2,user_ans);
                }

                if(!verdict) {
                    System.out.println("Incorrect Answer");
                    System.out.println("You didn't won any Toy");
                }

                else{

                    Toy won_toy = null ;
                    boolean exc = false ;

                    try{
                        won_toy = curr_tile.getToy();                     // Check for null pointer
                    }

                    catch(NoToyException e){

                        try{
                            won_toy = curr_tile.getToy();                  // REDO STEP

                        }catch (NoToyException ex){

                            System.out.println(ex.getMessage());
                            exc = true ;
                        }
                    }

                    if(exc){ chance_num++ ; continue ; }

                    player.add_Toy(won_toy);
                    System.out.println("You won a Toy " + won_toy.getName());
                }
            }

            chance_num++;
        }

        System.out.println("Game Over");
        System.out.println("Soft toys won by you are :");
        player.display_bucket();
    }

    String question_type(String inp) throws InvalidInputException{

        if(((inp.toLowerCase()).equals("integer")) || ((inp.toLowerCase()).equals("string"))){
            return inp.toLowerCase();
        }

        throw new InvalidInputException("Input must be Integer or String");
    }

    int random_num_generator(){

        return (1+rand.nextInt(25));
    }

    int Number_generator(){
        return (rand.nextInt(10000)-5000);
    }

    String String_generator(int len){

        String s = "";

        for (int i = 0; i < len; i++) {

            char c = (char)(97+rand.nextInt(26));
            s+=c;
        }
        return s ;
    }

    void print_line(){
        System.out.println();
    }

    String helper(int i){

        if(i>=5){return null;}            // Null

        String[] arr = {"First","Second","Third","Fourth","Fifth"};
        return arr[i];
    }
}
