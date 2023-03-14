// This "Card" class will assign a suit and a value to every card
// Calls from both "Suit" and "Rank" classes to do so
// Contains methods to print these values to console
public class Card {

      // Variables taken from Suit and Value classes
      // For use in this class only
     private Suit suit;
     private Rank rank;

      // Constructor for Card class
      // Creates a card from a given suit and value
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }// end of first Card class constructor

      // Second Constructor for Card class
      // Sets the suit and rank values of a card equal
      // to one provided from parameters
    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }// end of second constructor

      // Returns the numerical value of the card
    public int getValue(){
        return rank.rankValue;
    }// end of getValue method

      // Returns the suit value of the card
    public Suit getSuit(){
        return suit;
    }// end of getSuit method

    public Rank getRank(){
        return rank;
    }// end of getRank method

      // Retrns the card as a readable strin
    public String toString(){
        return ("|"+ rank + " of "+ suit + "| (" + this.getValue() + ")");

    }// end of toString method
}
