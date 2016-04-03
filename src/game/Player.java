package game;

import cards.Card;

/**
 * A class representing a player of the game. A player is a human player.
 */
public class Player {
    private Card[] hand;
    private Card[] wins;
    private int score;
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

    public Card[] getWins() {
        return wins;
    }

    public void setWins(Card[] wins) {
        this.wins = wins;
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

