# Cards Library
The cards library is a small (very small) library that simulates cards. It will be updated as needed, but for the most part, it's pretty much done as it stands. Feel free to use it if you wish to have a base point for a card game. I sure will.
## Classes
A brief overview of the classes in this library follows:
### Card.java
A card is defined as a number (or face) and a suit. Suits are of the enum Card.Suit, as there are only 4 of them, and they never change.

#####Class Methods:
|Modifier and Type | Method | Description|
|---|---|---|
|Card.Suit | getSuit()| Get the suit of the card|
|int | getValue()| get the value of the card|
|void | setSuit(Card.Suit suit)| set the suit of the card by hand|
|void | setValue(int value)| Set the value of the card (0-13 or 99)|
|java.lang.String | toString()| Get a string representing the object |

### Deck.java
A deck is defined as a collection (or stack, book, what have you) of cards. Any amount of cards greater than 1 is a deck (a single card would be just a single card.)

#####Class Methods:
|Modifier and Type | Method | Description|
|---|---|---|
|Card |addCard(Card toAdd)|I personally don't see myself using this, but here it is just in case: Add a card to the last position of the deck (the bottom of the pile)|
|void |cutDeck(Deck.Cut cutType)|Cut the deck into segments and put them back together.|
|Card[] | deckToCardArray()| Return the deck as an array of cards |
|void|dovetailShuffle()|A 'perfect dovetail' is when you split the deck in half and alternate cards from the top and bottom decks to shuffle it.|
|Card|getCard(int index)|Get a card at an index (for things like "Get the fifth card" or whatever)|
|int | getCount()|return the amount of cards in the deck|
|static Deck | mergeDecks(Deck... decks) |Merge several decks into 1; Static because this is independent of the 'deck' attribute|
|Card | removeCard(Card toRemove) |Remove a card from a deck given the card to remove|
|Card | removeCard(int index) |Remove a card from a deck given a certain index |
|void | reverseDeck() |Reverse the contents of the deck.|
|void | shuffleDeck() |Alternative way to simulate a real shuffle of the deck of cards - Random shuffle, then take the deck and cut it half, third, quarter, third; then, take the deck, split it, and apply that algorithm to the deck segments.|
|void | shuffleDeckRand() |A pseudorandom way to shuffle the deck - takes a card from random and switches it with the card at deck[i] (Found online somewhere on a .edu site.|
|Deck[] | splitDeck(int divisor) |split the deck into multiple decks semi-evenly.|
|java.lang.String | toString() | return a string that shows how many cards are left in the deck.|