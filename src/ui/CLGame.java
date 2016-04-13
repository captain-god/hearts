package ui;

import game.Bot;
import game.Game;

import java.io.PrintStream;
import java.util.Scanner;

import static game.Bot.Difficulty.EASY;

/**
 * Command Line version of the game. I'm gonna develop the game here and then port to the JavaFX version.
 */
public class CLGame {
    private static PrintStream out = new PrintStream(System.out);
    private static Scanner in = new Scanner (System.in);

    public static void main (String args[]){
        out.println("How many players?");
        int players = in.nextInt();
        out.println("How many of them are human?");
        int humans = in.nextInt();
        out.println("What score do you want to play to? (50 is recommended)");
        int score = in.nextInt();

        Bot.Difficulty diff = EASY;

        new Game(players, humans, diff, score);

    }
}
