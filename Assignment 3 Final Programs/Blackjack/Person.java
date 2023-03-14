// This Person class is used for sharing logic between
// The "Player" and "Dealer" classes
public abstract class Person {

    // hand holds the Person's active playing cards
    private Hand hand;
    // string to hold whether their name is Player or Dealer
    private String name;

      // constrctor for creating a new Person
    public Person(){
        // Gives them a Hand and a name
        this.hand = new Hand();
        this.name = "";
    }// end of Person constructor


    //Getter and Setters
    public Hand getHand(){
        return this.hand;
    }// end of getHand method
    public void setHand(Hand hand){
        this.hand = hand;
    }// end of setHand method
    public String getName(){
        return this.name;
    }// end of getName method
    public void setName(String name){
        this.name = name;
    }// end of setName method

      // Method to print a formatted version
      // of the Person's hand
    public void printHand(){
        System.out.println(this.name + "'s hand is:");
        System.out.println(this.hand + "\nTotal hand: " + 
            this.hand.calculatedValue());
    }// end of printHand method

      // Method for handling hit actions
      // Calls the reloadDeck method in the Deck class
    public void hit(Deck deck, Deck discard){

        // If are no cards left in the deck,
        if (!deck.hasCards()) {
            // reload the deck from the discard pile
            deck.reloadDeckFromDiscard(discard);
        }
        // takes a card from the deck
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        // prints out the hand
        this.printHand();
        }// end of if statement
    
      // Returns a boolean value as "true"
      // If person has a 21
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }// end of if/else statement
    }// end of hasBlackJack boolean
}// end of Person class
