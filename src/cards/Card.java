package cards;

public class Card {
    public enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS, JOKER
    }

    private Suit suit;
    private int value;

    /**
     * Create a card
     *
     * @param value the numeric value of the card (1-13)
     * @param suit  the suit of the card, of the Suit enum
     */
    public Card(int value, Suit suit) {
        this.setValue(value);
        this.setSuit(suit);
    }

    /**
     * the parameterless constructor creates a Joker card.
     */
    public Card() {
        this.value = 99;
        this.suit = Suit.JOKER;
    }

    @Override
    public String toString() {
        // Check to see if it's a joker before proceeding
        // (either indication of a joker will work.)
        if (this.value == 99 || this.suit == Suit.JOKER) return "Joker";

        String cardName = "";
        if (this.value == 1) {
            cardName += "Ace of ";
        } else if (this.value == 11) {
            cardName += "Jack of ";
        } else if (this.value == 12) {
            cardName += "Queen of ";
        } else if (this.value == 13) {
            cardName += "King of ";
        } else {
            cardName += this.value + " of ";
        }

        cardName += this.suit.toString().substring(0, 1) + this.suit.toString().toLowerCase().substring(1);

        return cardName;
    }

    /**
     * get the value of the card
     * @return the value of the card (1-13 or 99)
     */
    public int getValue() {
        return value;
    }

    /**
     * Set the value of the card (0-13 or 99)
     * @param value The value to set the card to.
     */
    public void setValue(int value) {
        if (value != 99) {
            if (value >= 1 && value <= 13) {
                this.value = value;
            }
        } else if (value == 99) {
            this.value = 99;
        }
    }

    /**
     * Get the suit of the card
     * @return the Suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * set the suit of the card by hand
     * @param suit the suit of the card (of the Suit enum)
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}