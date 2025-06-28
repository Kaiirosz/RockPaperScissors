import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final Scanner sc;
    private final Player player1;
    private final Player player2;

    public GameLogic(){
        player1 = new Player();
        player2 = new Player();
        sc = new Scanner(System.in);
    }

    public void startGame(){
        System.out.println("Rock Paper Scissors Game!!");
        System.out.println("-------");
        getHand();

    }

    public void getHand(){
        System.out.println("What will you throw??");
        System.out.println("Rock / Paper / Scissors");
        String output = sc.nextLine().toUpperCase();
        switch(output) {
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



}
