package model;

public enum Hand {
    ROCK,
    PAPER,
    SCISSORS;

    public boolean beats(Hand otherHand) {
        return (this == ROCK && otherHand == SCISSORS) ||
                (this == PAPER && otherHand == ROCK) ||
                (this == SCISSORS && otherHand == PAPER);
    }

    public boolean isSame(Hand otherHand){
        return this == otherHand;
    }
}
