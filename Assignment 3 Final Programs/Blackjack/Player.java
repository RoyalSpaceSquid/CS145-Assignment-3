import java.util.Scanner;
// This Player class extends the Person class, allowing it to
// Print the player's hand and determine if they have a blackjack
// Scanner is used to ask the player if they want to hit or stand

public class Player extends Person {

    Scanner input = new Scanner(System.in);

    //Create a new Player
    public Player() {
        super.setName("Player");

    }

      // Method for allowing the player to hit or stand
      // Calls both the main deck and the discard deck
      // Uses try-catch for error prevention:
      // Boolean stays true while reading player's input,
      //    gets set to false upon successfully reading an int
      //    remains true when failing to get an int value,
      //    allowing user to try entering a new one
    public void makeDecision(Deck deck, Deck discard) {

        // decision holds the numerical choice to hit or stand
        int  decision = 0;
        boolean getNum = true;

        // while getting a number,
        while(getNum){
            // try to get that number
            try{
                System.out.println("Would you like to: (1) Hit or (2) Stand?");
                decision = input.nextInt();
                getNum = false;

            }
            //catch any exceptions and try again
            catch(Exception e){
                System.out.println("Invalid input, please try again");
                input.next();
            }// end of try/catch statement
        }// end of while loop

        // if person decides to hit,
        if (decision == 1) {
            // hit the deck
            this.hit(deck, discard);
            // return in event of blackjack or bust
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                // Allows the choice to hit or stand again
                // Uses same deck
                this.makeDecision(deck, discard);
            }// end of nested if/else

        } else {
            // will stand on any input besides 1
            System.out.println("You stand.");
        }// end of if/else statement
    }// end of makeDecision method


}
