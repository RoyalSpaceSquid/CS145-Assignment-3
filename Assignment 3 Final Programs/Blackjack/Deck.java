import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
// This CardDeck class is used to manage an ArrayList of cards

public class Deck {

      // An arraylist for holding the deck of cards
    private ArrayList<Card> deck;

      // Creates a new deck of cards
    public Deck(){
        deck = new ArrayList<Card>();
    }// end of Deck creation constructor

      // Constructor for CardDeck class
      // Uses a boolean value to initiate start of a new deck
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            // Goes through all the suits
            for(Suit suit : Suit.values()){
                // Goes through all the ranks
                for(Rank rank : Rank.values()){
                    // Adds a new card with combined
                    // Suit and Rank values
                    deck.add(new Card(suit, rank));
                }
            }
        }// end of if statement
    }// end of second deck constructor

      // The card added to this deck
    public void addCard(Card card){
        deck.add(card);
    }

      // Creates an arraylist of cards
      // To be added to the deck
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

      // for loop method goes through each card in the deck,
      // adding it to the returned String value
      // also adds a character for a new line
    public String toString(){
        String output = "";

        for(Card card: deck){
            output += card;
            output += "\n";
        }// end of for loop
        return output;
    }// end of toString method
      // Shuffles the deck
    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

      // Method to return the top card from the deck
      // while also removing it from the deck
    public Card takeCard(){
               // Takes a copy of the first card from the deck
            Card cardToTake = new Card(deck.get(0));
               // Removes the card from the deck
            deck.remove(0);
               // Returns the card to the deck
            return cardToTake;

    }

      // Method to determine if a deck has cards in it or not
      // by using ArrayList.size()
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }// end of if/else statement
    }// end of hasCards statement
      
      // Returns the number of cards left in the deck
    public int cardsLeft(){
        return deck.size();
    }

      // Returns the arraylist containing all cards in deck
    public ArrayList<Card> getCards() {
        return deck;
    }

   // Method to add cards from the "discard" deck
   // Empties the discard pile by using the ArrayList.clear() method
   // Adds multiple cards at once with the ArrayList.addAll() method
    public void emptyDeck(){
        deck.clear();
    }// end of emptyDeck method


      // shuffles the cards from the discard deck
      // into the main deck
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Out of cards, refreshing...");
    }// end of reload method


}
