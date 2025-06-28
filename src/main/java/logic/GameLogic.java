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

    public GameLogic() {
        player1 = new Player();
        player2 = new Player();
        sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Rock Paper Scissors game.Game!!");
        System.out.println("-------");
        getHand();
        generatePlayer2Hand();
        System.out.println("Player 2 throws a " + player2.getHand());
        System.out.println("YOU " + getResult() + "!!");
        System.out.println("Play Again? (Y/N)");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("Y")){
            startGame();
        }
    }

    public void getHand() {
        System.out.println("What will you throw??");
        System.out.println("ROCK / PAPER / SCISSORS");
        String output = sc.nextLine().toUpperCase();
        switch (output) {
            case "ROCK":
                player1.setHand(Hand.ROCK);
                break;
            case "PAPER":
                player1.setHand(Hand.PAPER);
                break;
            case "SCISSORS":
                player1.setHand(Hand.SCISSORS);
                break;
            default:
                System.err.println("Invalid model.Hand!");
                getHand();
        }
    }

    public void generatePlayer2Hand() {
        Random random = new Random();
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
        if (playerHand.isSame(computerHand)){
            return Result.DRAW;
        }
        if (playerHand.beats(computerHand)){
            return Result.WIN;
        }
        else {
            return Result.LOSE;
        }
    }
}
