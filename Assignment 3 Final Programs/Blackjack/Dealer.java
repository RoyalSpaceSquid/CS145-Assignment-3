// This Dealer class handles the specific operations for the dealer
public class Dealer extends Person {

   // Constructor for Dealer class
   // Uses super keyword when calling the "Person" class
   // to name this person as "Dealer"
   public Dealer () {
      super.setName("Dealer");
   }
   
   // Method to show the Dealer's first card
   // Without revealing the second
   public void printFirstHand() {
      System.out.println("The dealer's hand looks like:");
      System.out.println(super.getHand().getCard(0));
      System.out.println("Second card is face down.");
   }// end of printFirstHand method
}// end of Dealer class