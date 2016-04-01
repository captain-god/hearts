package cards;

public class Deck {
    public enum Cut {
        HALF, THIRD, QUARTER
    }

    private Card[] deck;

    /**
     * Create a deck of 52 cards.
     */
    public Deck() {
        this.deck = new Card[52];
        Card card;
        int counter = 0;

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                card = new Card();
                if (j == 0) {
                    card.setSuit(Card.Suit.CLUBS);
                } else if (j == 1) {
                    card.setSuit(Card.Suit.DIAMONDS);
                } else if (j == 2) {
                    card.setSuit(Card.Suit.HEARTS);
                } else {
                    card.setSuit(Card.Suit.SPADES);
                }

                card.setValue(i + 1);
                deck[counter] = card;
                counter++;
            }
        }
    }

    /**
     * Make a new deck from an array of cards
     * @param cardsToUse the array of cards to make a new deck with
     */
    public Deck(Card[] cardsToUse){
        setDeck(cardsToUse);
    }

    /**
     * Get a card at an index (for things like "Get the fifth card" or whatever)
     *
     * @param index the index in the deck (0-51)
     * @return the card found at the index (null if invalid number)
     */
    public Card getCard(int index) {
        if (index < 52 && index >= 0) {
            return this.deck[index];
        } else return null;
    }

    /**
     * Remove a card from a deck given a certain index
     * @param index the index of the card being removed
     * @return the card that was removed (For verification purposes)
     */
    public Card removeCard(int index) {
        if (index < getCount() && index >= 0) {
            Card removed = deck[index];
            Card[] newDeck = new Card[deck.length - 1];
            int i = 0;

            for (Card c : deck) {
                if (c != removed) {
                    newDeck[i] = c;
                    i++;
                }
            }

            deck = newDeck;
            return removed;
        } else return null;
    }

    /**
     * Remove a card from a deck given the card to remove
     * @param toRemove The card object to remove
     * @return the card removed (for verification purposes)
     */
    public Card removeCard(Card toRemove){
        Card[] newDeck = new Card[deck.length - 1];
        if (toRemove != null){
            int i = 0;
            for (Card c : deck){
                if (c != toRemove){
                    newDeck[i] = c;
                    i++;
                }
            }
            deck = newDeck;
            return toRemove;
        } else return null;
    }

    /**
     * I personally don't see myself using this, but here it is just in case:
     * Add a card to the last position of the deck (the bottom of the pile)
     * @param toAdd the card to add to the deck.
     * @return the card added to the deck or null if unsuccessful
     */
    public Card addCard(Card toAdd){
        if (toAdd == null) return null;
        else {
            Card[] newDeck = new Card[deck.length + 1];
            System.arraycopy(deck,0,newDeck,0,newDeck.length);
            newDeck[newDeck.length-1] = toAdd;

            return toAdd;
        }
    }

    /**
     * Set the deck to a specific set of cards.
     * @param deck the book of cards to use as the deck.
     */
    private void setDeck(Card[] deck) {
        this.deck = deck;
    }

    /**
     * Alternative way to simulate a real shuffle of the deck of cards -
     * Random shuffle, then take the deck and cut it half, third, quarter, third;
     * then, take the deck, split it, and apply that algorithm to
     * the deck segments. Rejoin the deck at the end.
     */
    public void shuffleDeck() {
        shuffleDeckRand();
        cutDeck(Cut.THIRD);
        cutDeck(Cut.QUARTER);
        cutDeck(Cut.HALF);
        cutDeck(Cut.THIRD);
        Deck[] split = splitDeck(2);
        split[0].reverseDeck();
        split[1].dovetailShuffle();
        mergeDecks(split[0], split[1]);
        dovetailShuffle();
    }

    /**
     * A pseudorandom way to shuffle the deck - takes a card from random and switches it
     * with the card at deck[i]
     * (Found online somewhere on a .edu site. cheers mate.)
     */
    public void shuffleDeckRand() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    /**
     * return the amount of cards in the deck
     * @return the amount of cards in the deck.
     */
    public int getCount() {
        return deck.length;
    }

    public Card[] deckToCardArray(){
        return deck;
    }

    @Override
    public String toString() {
        return "deck(" + getCount() + ")";
    }

    /**
     * Cut the deck into segments and put them back together. This is seperate from
     * splitting the deck.
     *
     * @param cutType Cut to make (Half, quarter or third)
     */
    public void cutDeck(Cut cutType) {
        Card[] tempDeck = new Card[deck.length];
        switch (cutType) {
            case HALF:
                // [1][2] to
                // [2][1]
                System.arraycopy(deck, 0, tempDeck, deck.length / 2, deck.length / 2 + deck.length % 2);
                System.arraycopy(deck, deck.length / 2, tempDeck, 0, deck.length / 2);
                break;
            case THIRD:
                // [1][2][3] to
                // [2][3][1]
                System.arraycopy(deck, 0, tempDeck, deck.length / 3 * 2, deck.length / 3 + deck.length % 3);
                System.arraycopy(deck, deck.length / 3, tempDeck, 0, deck.length / 3);
                System.arraycopy(deck, deck.length / 3 * 2, tempDeck, deck.length / 3, deck.length / 3);
                break;
            case QUARTER:
                // [1][2][3][4] to
                // [3][1][4][2]
                System.arraycopy(deck, 0, tempDeck, deck.length / 4, deck.length / 4);
                System.arraycopy(deck, deck.length / 4, tempDeck, deck.length / 4 * 3, deck.length / 4 + deck.length % 4);
                System.arraycopy(deck, deck.length / 4 * 2, tempDeck, 0, deck.length / 4);
                System.arraycopy(deck, deck.length / 4 * 3, tempDeck, deck.length / 4 * 2, deck.length / 4);
                break;
        }
        deck = tempDeck;
    }

    /**
     * split the deck into multiple decks semi-evenly.
     * @param divisor the amount of sections to split the deck into
     * @return an array of Decks containing the split deck
     */
    public Deck[] splitDeck(int divisor){
        Deck[] splitDecks = new Deck[divisor];

        for(int j = 0; j < divisor; j++) {
            Card[] deckChunk;
            //Only check if the deck would have a remainder on the first iteration -
            //remainder will be added to the first deck.
            if (j == 0 && deck.length % divisor != 0){
                deckChunk = new Card[deck.length / divisor + deck.length % divisor];
                System.arraycopy(deck, 0, deckChunk, 0, deckChunk.length);
            } else {
                deckChunk = new Card[deck.length /divisor];
                System.arraycopy(deck, deck.length / divisor * j + 1, deckChunk, 0, deckChunk.length);
            }
            splitDecks[j] = new Deck(deckChunk);
        }

        return splitDecks;
    }

    /**
     * Merge several decks into 1; Static because this is independent of the 'deck' attribute
     * @param decks the list of decks to merge
     * @return a new deck that is the sum of all decks put into the arguments.
     */
    //TODO: Make more elegant later
    public static Deck mergeDecks(Deck... decks) {
        int deckSum = 0;

        for (Deck d : decks){
            deckSum += d.getCount();
        }

        Card[] newDeck = new Card[deckSum];
        int i = 0;

        for (Deck d : decks){
            for (Card c : d.deckToCardArray()){
                newDeck[i] = c;
                i++;
            }
        }

        return new Deck(newDeck);
    }

    /**
     * A 'perfect dovetail' is when you split the deck in half and
     * alternate cards from the top and bottom decks to shuffle it.
     * Doing this twice in a row should negate the process.
     */
    public void dovetailShuffle() {
        Deck[] split = splitDeck(2);
        int count = 0;
        for ( int i = 0; i < deck.length / 2; i++){
            deck[count] = split[0].getCard(i);
            count++;
            if (split[1].getCount() >= i){
                deck[count] = split[1].getCard(i);
                count++;
            }
        }
    }

    /**
     * Reverse the contents of the deck.
     */
    public void reverseDeck() {
        for (int i = 0; i < deck.length / 2; i++) {
            Card temp = deck[i];
            deck[i] = deck[deck.length - i - 1];
            deck[deck.length - i - 1] = temp;
        }
    }
}
