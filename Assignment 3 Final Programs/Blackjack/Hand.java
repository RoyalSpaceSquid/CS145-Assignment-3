import java.util.ArrayList;
import java.util.Collections;
// This Hand class is used to manage an ArrayList of Cards
// Contains methods for calculating value of the and,
// taking cards from a deck, and discarding a hand to a deck
public class Hand {

    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

      // Takes a card from the top of the deck
      // And adds it to the hand
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }// end of take Method

      // Method to return a hand to the discard deck
    public void discardHandToDeck(Deck discardDeck){

        // copies cards from hand to discard deck
        discardDeck.addCards(hand);

        // clears the hand
        hand.clear();
   }// end of discard method

      // Method for printing a Dealer's or
      // Player's current hand
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
    }// end of for loop
         //returns the String just formatted
        return output;
    }// end of toString method


      // Method for returning an int which contains a hand's value
    public int calculatedValue(){

        // variable to count number of aces, and current total value
        int value = 0;
        int aceCount = 0;

        // For each card in this hand,
        for(Card card: hand){
            // Add the card value to the hand
            value += card.getValue();
            // Counts how many aces have been added
            if (card.getValue() == 11){
                aceCount ++;
            }
        }// end of for loop
        
         /* Starts a while loop in the event of a hand containing
            Aces when the value is greater than 21
            If possible, sets each ace value to 1 to keep the value under 21 */
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }// end of while loop
        return value;

    }
      // idx contains the card index we get
    public Card getCard(int idx){
        return hand.get(idx);
    }// end of getCard method
}
