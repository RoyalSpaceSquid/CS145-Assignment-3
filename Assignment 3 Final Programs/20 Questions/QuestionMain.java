// Blake Nelson
// Class: CS 145
// Date: March 10, 2023
// Assignment: Lab 6: 20 Questions
/* This program plays a guessing game by asking a user multiple
   questions to find out what they're thinking of.
   It can read an old tree from the file if the user wants 
   before starting a new game, and end results are always
   written to a file for if the user wants to continue using
   the tree they just played with for their next game.*/

import java.io.*;
import java.util.*;

public class QuestionMain {
    // designates the file to always be used as "question.txt"
    public static final String QUESTION_FILE = "question.txt";
    
    // main method welcomes user to the game
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the game of 20 Questions!");
        System.out.println();
        
        // keeps the tree in use current with the game being played
        QuestionTree questions = new QuestionTree();
        
        // implements the tree from the previous game if the user
        // inputs yes to the prompt
        if (questions.toYes("Would you like to read from the previous game's tree?"))
            questions.read(new Scanner(new File(QUESTION_FILE)));
        System.out.println();
        
        // continues the game until the program either
        // guesses correctly or fails, providing an
        // option to play again when finished
        do {
            System.out.println("Please think of an object for me to guess.");
            questions.askQuestions();
            System.out.println();
        } while (questions.toYes("Would you like to play again?"));
      questions.write(new PrintStream(new File(QUESTION_FILE)));
    }// end of main method
}// end of class