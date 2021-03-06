package com.company;

import java.util.*;

public class Game {

    private final ArrayList<Floor> game_track ;
    private final Player player ;
    private final Dice dice ;
    private int total_points ;
    private Floor curr_floor;
    private int lastfloor ;
    private static Scanner scanner = new Scanner(System.in);

    Game(String Name) {

        this.player = new Player(Name,-1) ;
        this.game_track = new ArrayList<>() ;
        this.total_points = 0 ;
        this.curr_floor = null ;
        this.dice = new Dice(2) ;
        this.setGame_track();
        this.lastfloor = 13 ;
    }

    void setGame_track(){

        game_track.add( new Emptyfloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Elevatorfloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Snakefloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Ladderfloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Cobrafloor());
        game_track.add( new Emptyfloor());
        game_track.add( new Emptyfloor());

        System.out.println("The Game Setup is ready !!!");
        print_break();

    }

    void addfloor(int ver){

        if(ver==1){ game_track.add(new Snakefloor()); lastfloor++ ; return ;}
        if(ver==2){ game_track.add(new Cobrafloor()); lastfloor++ ; return ;}
        if(ver==3){ game_track.add(new Emptyfloor()); lastfloor++ ; }
    }

    void change_dice(int x){
        dice.setNum_face(x);
    }

    int RollDice(){
        dice.roll();
        return dice.getFace_value();
    }

    void Initialise() {

        while(true){

            System.out.print("Hit Enter to Roll Dice : ");
            scanner.nextLine();

            if(this.RollDice()==1){

                player.setCurr_position(player.getCurr_position()+1,lastfloor);
                this.curr_floor = get_curr_floor(player.getCurr_position());
                if(curr_floor==null){return;}
                this.total_points += curr_floor.getScore_awarded();
                this.print_current_status();
                print_break();
                break;
            }

            System.out.println("Game Cannot Start until you get 1 ");
            print_break();
        }
    }

    void start(){

        while(true) {

            System.out.print("Hit Enter to Roll Dice : ");
            scanner.nextLine();

            int throw_value = RollDice();

            if (player.getCurr_position() + throw_value <= lastfloor) {

                player.setCurr_position(player.getCurr_position() + throw_value , lastfloor);
                this.curr_floor = get_curr_floor(player.getCurr_position());
                if(curr_floor==null){return;}
                this.total_points += curr_floor.getScore_awarded();
                this.print_current_status();

                if(isFinished()){ break ; }

                if(curr_floor.isEmpty()){
                    print_break();
                    continue;
                }

                player.setCurr_position(curr_floor.getNext_floor_position(),lastfloor);
                this.curr_floor = get_curr_floor(player.getCurr_position());

                if(curr_floor==null){ return; }
                this.total_points += curr_floor.getScore_awarded();
                this.print_current_status();
                print_break();
            }

            else{
                System.out.println("Player Cannot move !");
                print_break();
            }
        }

        System.out.println("Game Over !");
        System.out.println(player.getName()+" accumulated " + this.total_points + " points");
        print_break();
    }

    boolean isFinished(){
        return player.getCurr_position() == this.lastfloor;
    }

    private void print_current_status(){

        System.out.println("Player position Floor : "+player.getCurr_position());
        System.out.println(player.getName()+" has Reached an "+ curr_floor.type()+" floor");
        System.out.println("Total points : "+ this.total_points );
    }

    private Floor get_curr_floor(int lvl){

        if( lvl < 0 || lvl > lastfloor ){
            System.out.println("Invalid Floor level");
            return null;
        }

        return game_track.get(lvl);
    }

    private void print_break(){
        System.out.println("---------------------------------------------------------------");
    }
}
