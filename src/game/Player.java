package game;

import cards.Card;

/**
 * A class representing a player of the game. A player is a human player.
 */
public class Player {
    private Card[] hand;
    private int points; // Points are how many points you have in a round
    private int score; // score is how many points in a game.
    private int playerID;

    public Player(int pid) {
        this.playerID = pid;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public Card playCard(Card card){
        if (card == null) return null;

        Card[] tempHand = new Card[hand.length - 1];

        for ( int i = 0; i < hand.length; i++){
            if (hand[i] != card){
                tempHand[i] = hand [i];
            }
        }

        hand = tempHand;
        return card;
    }

    //todo: make some sorting methods

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
}

