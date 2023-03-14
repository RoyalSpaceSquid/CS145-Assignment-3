// Programmer: Blake Nelson
// Class: CS &141
// Date: January 10, 2023
// Assignment: Lab 1: Guessing Game
// Purpose:    Allows a user to play a simple guessing game. 
//             Various statistics will be given upon ending the game’s session.

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
   
   
      public static void main(String[] args) {
             
         int numberOfGuesses = 0;
         int totalGames = 0;
         int bestGame = 201;
            
         intro();
         game(numberOfGuesses, totalGames, bestGame);

      }
         
         public static void game(int numberOfGuesses, int totalGames, int bestGame) {
                                    
            Random rand = new Random();  
            int numberToGuess = rand.nextInt(200);
            
            Scanner input = new Scanner(System.in);
            
            //leaves "guess" variable to be determined by user's input
            //boolean is used to flag the game "on" or "off"
            int guess;
            int guessesThisGame = 0;
            boolean win = false;
            
               while (win == false) {
               
                  System.out.printf("I'm thinking of a number between 1 and 200...%n%nYour guess? ");
                  guess = input.nextInt();
                  numberOfGuesses++;
                  guessesThisGame++;
                  
                  if (guess == numberToGuess) {  
                     win = true; 
                     totalGames++;   
                  }
                  
                  else if (guess < numberToGuess) {
                     System.out.println("It's higher.");
                  }
                  else if (guess > numberToGuess) {
                     System.out.println("It's lower.");
                  }

               }
                  if (bestGame > guessesThisGame) {
                     bestGame = guessesThisGame;
                  } //updates the bestGame integer to a lower guess amount if obtained by player
            
               gameEnd(numberToGuess, guessesThisGame);
                  
               Scanner replay = new Scanner(System.in);
               System.out.print("Would you like to play again? (y/n) ");
               String userReplay = replay.next().substring(0, 1);
               
                  if (userReplay.equalsIgnoreCase ("Y")) {
                     game(numberOfGuesses, totalGames, bestGame);
                  }//starts another session of the game
                        
                  else if (userReplay.equalsIgnoreCase ("N")) {
                     results(totalGames, numberOfGuesses, bestGame);
                  }//ends the game and shows the results
                        
         }
                                 
         //method for displaying results after winning
         public static void gameEnd(int numberToGuess, int guessesThisGame) {
            System.out.println("Correct, the number was " + numberToGuess + ".");
            System.out.println("You got it right in " + guessesThisGame + " guesses.");
         }
         
         //method to welcome the user to the game
         public static void intro() {
            System.out.println("This program allows you to play a guessing game.");
            System.out.println("I will think of a number between 1 and");
            System.out.println("200 and will allow you to guess until");
            System.out.println("you get it. For each guess, I will tell you");
            System.out.println("whether the right answer is higher or lower");
            System.out.println("than your guess.\n");
         }
         
         //method to display overall game session results
         public static void results(int totalGames, int numberOfGuesses, int bestGame) {
            double guessesPerGame = (double) numberOfGuesses/totalGames;
            System.out.println("Overall results:");
            System.out.println("\tTotal games\t\t = " + totalGames);
            System.out.println("\tTotal guesses\t = " + numberOfGuesses);
            System.out.println("\tGuesses/game\t = " + guessesPerGame);
            System.out.println("\tBest game\t\t = " + bestGame);
         }
         
         
}    