package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Reader.init(System.in);

        System.out.print("Enter the Player Name and Hit Enter : ");
        String name = Reader.reader.readLine();

        Game game = new Game(name);

//        while(true){
//        System.out.print("Would you like to add more similar floors in game track ? [Y/N]");
//

        //game.addFloor();

        game.Initialise();

        game.start();

    }
}
