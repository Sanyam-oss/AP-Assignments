package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Reader.init(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hit Enter to Start the Game !");
        scanner.nextLine();

        Gameplay Game = new Gameplay();

        Game.play();
    }
}
