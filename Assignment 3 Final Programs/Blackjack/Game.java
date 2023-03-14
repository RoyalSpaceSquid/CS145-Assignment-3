// This Game class contains the methods used for
// The main part of playing the game
// Gives variables representing the Player and Dealer
// Contains two decks - a main deck and discard deck
// Shuffles deck and starts a new round by calling a new startRound method
// Total numbers of wins, losses, and draws are all recorded

import java.util.Scanner;
public class Game {

    //Declare variables needed for Game class
   private Deck deck, discarded;

   private Dealer dealer;
   private Player player;
   private int wins, losses, draws;


   // Constructor for the Game class
   // Creates variables, shuffles deck and begins the Game
   public Game(){
   
   // Creates a new deck with 52 cards
      deck = new Deck(true);
   // Creates a new empty deck
      discarded = new Deck();

      dealer = new Dealer();
      player = new Player();
   
   
    // Shuffle the deck and start the first round
      deck.shuffle();
      startRound();
   }// end of Game class constructor


   // Method to start a round of the game
   // Records wins, losses, and draws
   private void startRound(){
   
      // If this is not the first round,
      // Places user's cards back into deck and displays score
      if(wins>0 || losses>0 || draws > 0){
         System.out.println();
         System.out.println("Starting Next Round... \nWins: " 
               + wins + " Losses: "+ losses + " Draws: "+ draws);
         dealer.getHand().discardHandToDeck(discarded);
         player.getHand().discardHandToDeck(discarded);
      }
   
     // Reshuffles the deck if there are less than
     // 4 cards when starting a round
      if(deck.cardsLeft() < 4){
      
         // Reloads deck from discard pile
         deck.reloadDeckFromDiscard(discarded);
      }
   
       // Gives the dealer two cards
      dealer.getHand().takeCardFromDeck(deck);
      dealer.getHand().takeCardFromDeck(deck);
   
      // Gives the player two cards
      player.getHand().takeCardFromDeck(deck);
      player.getHand().takeCardFromDeck(deck);
   
         // Show the dealers hand with one card rank down
      dealer.printFirstHand();
   
         // Show the player's hand
      player.printHand();
   
         // if/else statement checks if Dealer has a Blackjack
      if(dealer.hasBlackjack()){
            //Shows that the dealer has BlackJack
         dealer.printHand();
      
            //Checks if the player also has BlackJack
         if(player.hasBlackjack()){
               //Ends the round with a draw
            System.out.println("You both have 21 - it's a draw.");
            draws++;
               //starts a new round
            startRound();
         }
         else{
            System.out.println("Dealer has BlackJack... you lose.");
            dealer.printHand();
            losses++;
            
               //starts a new round upon player losing
            startRound();
         } // end of if/else statement for draw
      } // end of if/else statement for dealer's blackjack
   
        // Checks if player has blackjack to start
        // By this point,
        // We know the dealer doesn't have blackjack
      if(player.hasBlackjack()){
         System.out.println("You have Blackjack! Congrats!");
         wins++;
         startRound();
      }// end of if statement for player's blackjack
   
        // Gives player decision to hit or stand
        // passes decks in event of a hit
      player.makeDecision(deck, discarded);
   
        // Check if there was a bust
      if(player.getHand().calculatedValue() > 21){
         System.out.println("You have gone over 21.");
         losses ++;
         startRound();
      }
   
        // Start of dealer's turn
      dealer.printHand();
      while(dealer.getHand().calculatedValue()<17){
         dealer.hit(deck, discarded);
      }
   
        // Checks who wins and count wins or loses
        // Adds to total counts for wins, losses and draws
      if(dealer.getHand().calculatedValue()>21){
         System.out.println("Dealer busts!");
         wins++;
      }
      else if(dealer.getHand().calculatedValue() > 
            player.getHand().calculatedValue()){
         System.out.println("You lose...");
         losses++;
      }
      else if(player.getHand().calculatedValue() > 
            dealer.getHand().calculatedValue()){
         System.out.println("You win!");
         wins++;
      }
      else{
         System.out.println("Push.");
         draws++;
      }// end of if/else statement
   
        //Starts a new round
      startRound();
   }// end of startRound method
}// end of Game class
