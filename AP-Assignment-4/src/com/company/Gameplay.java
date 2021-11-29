package com.company;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Gameplay {

    private final ArrayList<Tile> Carpet ;
    private final Player player ;
    private final Calculator calculator ;
    private Tile curr_tile ;
    private int curr_pos ;
    private int chance_num ;
    private final int max_chances ;
    private final static Scanner scanner = new Scanner(System.in) ;
    private final static Random rand = new Random() ;

    Gameplay(){

        this.Carpet = new ArrayList<>();
        this.player = new Player();
        this.calculator = new Calculator();
        this.curr_pos = 0 ;
        this.curr_tile = null ;
        this.set_carpet();
        this.max_chances = 5 ;
        this.chance_num = 0 ;
    }

    void set_carpet(){

        Carpet.add(new Tile());                    // To apply 1-based indexing and exception creation
        Carpet.add(new Tile("Jerry"));
        Carpet.add(new Tile("Mickey Mouse"));
        Carpet.add(new Tile("Chandler"));
        Carpet.add(new Tile("Doobie"));
        Carpet.add(new Tile("Doraemon"));
        Carpet.add(new Tile("Donald Duck"));
        Carpet.add(new Tile("Ninja Hathori"));
        Carpet.add(new Tile("Ben10"));
        Carpet.add(new Tile("Shinchan"));
        Carpet.add(new Tile("Oswald"));
        Carpet.add(new Tile("Oggie"));
        Carpet.add(new Tile("Motu Patlu"));
        Carpet.add(new Tile("Tom"));
        Carpet.add(new Tile("Spongebob"));
        Carpet.add(new Tile("Popeye"));
        Carpet.add(new Tile("Snoopy"));
        Carpet.add(new Tile("Simpson"));
        Carpet.add(new Tile("Winnie"));
        Carpet.add(new Tile("Superman"));
        Carpet.add(new Tile("Phineas"));

        System.out.println("Game is Ready !!!");
    }

    void play() throws IOException {

        while(chance_num < max_chances){

            print_line();
            System.out.print("Hit Enter for your "+helper(chance_num)+" hop!");
            scanner.nextLine();

            curr_pos = this.random_num_generator();

            try{ curr_tile = Carpet.get(curr_pos); }  // IndexOutofBoundException

            catch (IndexOutOfBoundsException e){

                System.out.println("Redbull gives you wings :)");
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash! ");
                chance_num++;
                continue ;
            }

            System.out.println( "You landed on Tile " + curr_pos );

            if((curr_pos & 1) == 0){            // Even Tile

                Toy won_toy ;

                try{ won_toy = curr_tile.getToy(); }                     // Check for null pointer (Clone issue)

                catch(NoToyException e){

                    try{ won_toy = curr_tile.getToy(); }                // REDO STEP

                    catch (NoToyException e1){
                        System.out.println(e1.getMessage());
                        chance_num++;
                        continue;
                    }
                }

                catch(NullPointerException e){
                    System.out.println(e.getMessage());
                    chance_num++;
                    continue;
                }

                player.add_Toy(won_toy);
                System.out.println("You won a " + won_toy.getName() + " soft toy");
            }

            else{

                boolean flag=true;
                String input = null ;

                while(flag) {

                    System.out.println("Question answer round. Integer or String? ");
                    String inp = Reader.next();
                    flag = false ;

                    try { input = question_type(inp);}

                    catch ( InvalidInputException e ) {
                        System.out.println(e.getMessage());
                        flag = true;
                    }
                }

                boolean verdict = false ;

                if(input.equals("integer")){

                    int op1 = Number_generator();
                    int op2 = Number_generator();

                    System.out.println("Calculate the result of "+op1+" divided by "+op2+ " [ X if Not Defined ] ");

                    String user_ans = Reader.next();

                    verdict = calculator.verify(op1,op2,user_ans);
                }

                if(input.equals("string")){

                    int len = 1+rand.nextInt(8);
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

                    System.out.println("Correct Answer");
                    Toy won_toy ;

                    try{ won_toy = curr_tile.getToy(); }

                    catch(NoToyException e){

                        try{ won_toy = curr_tile.getToy(); }

                        catch (NoToyException e1){
                            System.out.println(e1.getMessage());
                            chance_num++;
                            continue;
                        }
                    }

                    catch(NullPointerException e){
                        System.out.println(e.getMessage());
                        chance_num++;
                        continue;
                    }

                    player.add_Toy(won_toy);
                    System.out.println("You won a " + won_toy.getName() + " soft toy");
                }
            }

            chance_num++;
        }

        print_line();
        System.out.println("Game Over !!!");
        print_line();
        System.out.println("Soft toys won :");
        player.display_bucket();
    }

    public String question_type(String inp) throws InvalidInputException{

        if(((inp.toLowerCase()).equals("integer")) || ((inp.toLowerCase()).equals("string"))){
            return inp.toLowerCase();
        }

        throw new InvalidInputException("Input must be Integer or String");
    }

    public int random_num_generator(){
        return (1+rand.nextInt(25));
    }

    public int Number_generator(){
        return (rand.nextInt(10000)-5000);
    }

    public String String_generator(int len){

        String s = "";

        for (int i = 0; i < len; i++) {
            char c = (char)(97+rand.nextInt(26));
            s += c ;
        }

        return s ;
    }

    public String helper(int i){

        String[] arr = {"First","Second","Third","Fourth","Fifth"};
        return arr[i];
    }

    public void print_line(){ System.out.println(); }
}
