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
        System.out.println("Rock Paper Scissors Game!!");
        System.out.println("-------");
        getHand();
        generatePlayer2Hand();
        System.out.println(player2.getHand());
        System.out.println("YOU " + getResult() + "!!");
        System.out.println("Play Again? (Y/N)");
        String input = sc.nextLine();
        if (input.equals("Y")){
            startGame();
        }
    }

    public void getHand() {
        System.out.println("What will you throw??");
        System.out.println("Rock / Paper / Scissors");
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
                System.err.println("Invalid Hand!");
                getHand();
        }
    }

    public void generatePlayer2Hand() {
        Random random = new Random();
        int randHand = random.nextInt(3 + 1);
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
        if (playerHand == Hand.ROCK) {
            if (computerHand == Hand.SCISSORS) {
                return Result.WIN;
            } else if (computerHand == Hand.PAPER) {
                return Result.LOSE;
            } else if (computerHand == Hand.ROCK) {
                return Result.DRAW;
            }
        } else if (playerHand == Hand.PAPER) {
            if (computerHand == Hand.ROCK) {
                return Result.WIN;
            } else if (computerHand == Hand.SCISSORS) {
                return Result.LOSE;
            } else if (computerHand == Hand.PAPER) {
                return Result.DRAW;
            }
        } else if (playerHand == Hand.SCISSORS) {
            if (computerHand == Hand.PAPER) {
                return Result.WIN;
            } else if (computerHand == Hand.ROCK) {
                return Result.LOSE;
            } else if (computerHand == Hand.SCISSORS) {
                return Result.DRAW;
            }
        }
        return null;
    }
}
