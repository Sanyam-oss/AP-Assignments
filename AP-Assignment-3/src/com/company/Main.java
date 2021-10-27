package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Reader.init(System.in);

        System.out.print("Enter the Player Name and Hit Enter : ");
        String name = Reader.reader.readLine();

        Game game = new Game(name);

        while(true) {

            System.out.print("Would you like to add more similar floors in game track ? [Y/N] ");
            String query = Reader.next();

            if (query.equals("N")) {
                break;
            }

            System.out.println("1 : Normal Snake | 2 : King Cobra | 3 : Empty ");
            int q = Reader.nextint();
            game.addfloor(q);
            System.out.println("Floor added Successfully");
        }

        System.out.print("Would you like to change Number of faces of dice [Y/N] ");
        String query = Reader.next();

        if (query.equals("Y")) {
            System.out.print("Enter Number of faces on dice : ");
            int face = Reader.nextint();
            game.change_dice(face);
        }


        game.Initialise();

        game.start();

    }
}
