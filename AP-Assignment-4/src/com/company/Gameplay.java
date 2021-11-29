package com.company;

import java.io.IOException;
import java.util.*;
import java.lang.*;

public class Gameplay {

    private final ArrayList<Tile> Carpet ;
    private final int carpet_length;
    private final Player player;
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
        this.curr_pos = 0 ;
        this.curr_tile = null ;
        this.set_carpet();
        this.last_tile = 20 ;
        this.max_chances = 5 ;
        this.chance_num = 0 ;
    }

    void set_carpet(){

        Carpet.add(null);                    // To apply 1-based indexing and exception creation
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

            System.out.print("Hit Enter for your "+helper(chance_num)+" hop!");
            scanner.nextLine();

            curr_pos = this.random_num_generator();

            // Array out of bound Exception

            if(curr_pos > last_tile){
                System.out.println("Redbull gives you wings :)");
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash! ");
                chance_num++;
                continue;
            }

            System.out.println("You landed on Tile "+curr_pos);

            if((curr_pos & 1) == 0){

                curr_tile = Carpet.get(curr_pos);
                Toy won_toy = curr_tile.getToy();        // Check for null pointer

                player.add_Toy(won_toy);
                System.out.println("You won a Toy " + won_toy.getName());
            }

            else{

                System.out.println("Question answer round. Integer or strings? ");
                String inp = Reader.next();

                if((inp.toLowerCase()).equals("integer")){

                }

                else if((inp.toLowerCase()).equals("string")){

                }

                else{
                    System.out.println("Invalid input , you lost a chance to win Toy this time");
                }
            }

            chance_num++;
        }

        System.out.println("Game Over");
        System.out.println("Soft toys won by you are :");
        player.display_bucket();
    }

    int random_num_generator(){
        return (1+rand.nextInt(25));
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
