package game;

import cards.Card;
import cards.Deck;

/**
 * The game class creates a game object and holds many useful functions for the game itself.
 */
public class Game {
    private int currentTurn = 0;
    private Player[] players;
    private int round = 0;
    private int scoreLimit;

    public Game(int amountOfPlayers, int humanPlayers, Bot.Difficulty difficulty, int scoreLimit) {
        this.scoreLimit = scoreLimit;
        setUpPlayers(amountOfPlayers, humanPlayers, difficulty);
        playHearts(amountOfPlayers);
    }


    private void playHearts(int amountOfPlayers) {
        while(true){
            setUpDeck(amountOfPlayers);
        }
    }

    /**
     * Set up player data;
     * @param amountOfPlayers the amount of players playing this round (between 3 and 5)
     * @param humanPlayers the amount of the players that are human players (the remainder will be bots)
     * @param difficulty the difficulty of the remaining bots
     */
    private void setUpPlayers(int amountOfPlayers, int humanPlayers, Bot.Difficulty difficulty) {
        players = new Player[amountOfPlayers];

        for (int i = 0; i < amountOfPlayers; i++){
            if (i < humanPlayers){
                players[i] = new Human(i);
            }
            else {
                players[i] = new Bot(i, difficulty);
            }
        }
    }

    /**
     * As described by Bicycle.com:
     * Deal the cards one at a time, face down, clockwise. In a four-player game, each is dealt 13 cards;
     * in a three-player game, the 2 of diamonds should be removed, and each player gets 17 cards;
     * in a five-player game, the 2 of diamonds and 2 of clubs should be removed so that each player will get 10 cards.
     * @param amountOfPlayers the amount of players playing a game.
     */
    private void setUpDeck(int amountOfPlayers){
        Deck theDeck = new Deck();
        theDeck.shuffleDeckRand();
        theDeck.shuffleDeck("shu f f ! le n 82"); //todo: Randomize this seed

        switch (amountOfPlayers){
            case 3:
                theDeck.removeCard(new Card(2, Card.Suit.CLUBS));
                dealToPlayers(theDeck);
                break;
            case 4:
                dealToPlayers(theDeck);
                break;
            case 5:
                theDeck.removeCard(new Card (2, Card.Suit.DIAMONDS));
                theDeck.removeCard(new Card (2, Card.Suit.CLUBS));
                dealToPlayers(theDeck);
                break;
            default:
                break;
        }
    }

    /**
     * split up a deck into hands and deal them to the players
     * @param deck the deck object to deal to the players
     */
    private void dealToPlayers(Deck deck){
        Deck[] split = deck.splitDeck(players.length);
        for (int i = 0; i < players.length; i++){
            players[i].setHand(split[i].deckToCardArray());
        }
    }

    private void takeTurn(){
        for(Player p : players){
            if ( p instanceof Human){
                //prompt a move
            }
            else {
                //play best card
            }
        }
    }
}