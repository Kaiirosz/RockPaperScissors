package logic;

import model.Hand;
import model.Result;
import player.Player;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final Scanner sc;
    private final Player player1;
    private final Player player2;
    private final Random random;
    private int wins, losses;

    public GameLogic() {
        random = new Random();
        sc = new Scanner(System.in);
        wins = 0;
        losses = 0;
        player1 = new Player();
        player2 = new Player();

    }

    public void startGame() {
        System.out.println("Rock Paper Scissors Game!!");
        System.out.println("-------");
        System.out.println("Best of how many wins?");
        int bestOf = sc.nextInt();
        sc.nextLine();
        while (true) {
            getHand();
            generatePlayer2Hand();
            System.out.println("Player 2 throws a " + player2.getHand());
            System.out.println("YOU " + getResult() + "!!");
            if (wins >= bestOf || losses >= bestOf){
                break;
            }
            System.out.println("Standing: " + wins + "-" + losses);
        }
        System.out.println("Game ends.");
        System.out.println("Final Standing: " + wins + "-" + losses);
    }


    public void getHand() {
        while (true) {
            System.out.println("What will you throw??");
            System.out.println("ROCK / PAPER / SCISSORS");
            String output = sc.nextLine().toUpperCase();
            switch (output) {
                case "ROCK":
                    player1.setHand(Hand.ROCK);
                    return;
                case "PAPER":
                    player1.setHand(Hand.PAPER);
                    return;
                case "SCISSORS":
                    player1.setHand(Hand.SCISSORS);
                    return;
                default:
                    System.err.println("Invalid Input!");
            }
        }
    }

    public void generatePlayer2Hand() {
        int randHand = random.nextInt(3) + 1;
        switch (randHand) {
            case 1:
                player2.setHand(Hand.ROCK);
                break;
            case 2:
                player2.setHand(Hand.PAPER);
                break;
            case 3:
                player2.setHand(Hand.SCISSORS);
                break;
        }
    }

    public Result getResult() {
        Hand playerHand = player1.getHand();
        Hand computerHand = player2.getHand();
        if (playerHand.isSame(computerHand)) {
            return Result.DRAW;
        }
        if (playerHand.beats(computerHand)) {
            wins++;
            return Result.WIN;
        } else {
            losses++;
            return Result.LOSE;
        }
    }
}
