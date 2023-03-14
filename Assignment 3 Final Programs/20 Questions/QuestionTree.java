import java.util.*; 
import java.io.*;
// Blake Nelson
// Class: CS 145
// Date: March 10, 2023
// Assignment: Lab 6: 20 Questions

/* This class implements a yes/no guessing game
   using binary trees that asks the client a series
   of yes or no questions. If answer is not in tree,
   the binary tree will be updated with the answer and
   a question corresponding to that answer. */

public class QuestionTree {
   // represents the root of the binary tree which
   // stores the questions and answers of the game
   private QuestionNode treeRoot;
   private Scanner console; // scanner for user input
   
   // constructor for a question tree with one leaf node,
   // representing the "answer" node and the object "computer"
   // serves as the default guess of the program
   public QuestionTree() {
      treeRoot = new QuestionNode("computer"); 
      console = new Scanner(System.in); 
   }// end of QuestionTree constructor
   
   // method which replaces the currently available tree
   // by reading an entire line of input, and then
   // constructing a tree based on a file
   public void read(Scanner input) {
      while(input.hasNextLine()) {
         treeRoot = readHelp(input); 
      }// end of while
   }// end of read method
   
   // helper method constructor which reads entire
   // lines of input for constructing a tree based
   // on a file
   private QuestionNode readHelp(Scanner input) {
      String type = input.nextLine();
      String guessData = input.nextLine();
      QuestionNode root = new QuestionNode(guessData);
  
      if (type.contains("Q:")) {
         root.yesNode = readHelp(input);
         root.noNode = readHelp(input);   
      }// end of if statement
      return root; 
   }// end of readHelp helper method
   
   // method for storing the currently-used tree to an output file
   // throws an IllegalArgumentException for when PrintStream
   // is not open for writing
   public void write(PrintStream output) {
      if (output == null) {
         throw new IllegalArgumentException(); 
      }// end of if statement
      writeToTree(treeRoot, output);
   }// end of write method
   
   // helper method for storing the content of
   // the currently-used tree to an input file
   private void writeToTree(QuestionNode treeRoot, PrintStream output) {
      if (isAnswerNode(treeRoot)) {
         output.println("A:"); 
         output.println(treeRoot.guessData);
      } else {
         output.println("Q:");
         output.println(treeRoot.guessData);
         writeToTree(treeRoot.yesNode, output);
         writeToTree(treeRoot.noNode, output); 
      }// end of if/else statement   
   }// end of writeToTree method
   
   // method which uses the current tree to ask the user
   // a series of yes/no questions until the program either
   // guesses their object correctly, or fails.
   // expands the tree to include the user's object upon failing,
   // as well as a new question for distinguising that object
   // from others within the tree
   public void askQuestions() {
      treeRoot = askQuestions(treeRoot); 
   }
   // private helper method that asks a series of yes/no questions
   // to the user within the current tree. 
   // expands tree on a failed guess to include the user's object
   // as well as a new question to distinguish that object
   // via user input from Scanner
   private QuestionNode askQuestions(QuestionNode current) {
      if (isAnswerNode(current)) {
         if (toYes("Is your object " + current.guessData +"?")) {
            System.out.println("I win, thanks for playing!");
         } else {
            System.out.println("I'm out of guesses, looks like you win!");
            System.out.print("What's your object's name? ");
            QuestionNode answer = new QuestionNode(console.nextLine());
            System.out.print("Please give me a yes/no question which will ");
            System.out.print("distinguish your object ");
            System.out.println("from my guess: "); 
            String question = console.nextLine(); 
            if (toYes("Alright, so what's the y/n answer for your object?")) {
               current = new QuestionNode(question, answer, current); 
            } else {
               current = new QuestionNode(question, current, answer); 
            }// end of double-nested if/else statement
         }// end of nested if/else statement
     
      } else {
         if (toYes(current.guessData)) {
            current.yesNode = askQuestions(current.yesNode);
         } else {
            current.noNode = askQuestions(current.noNode); 
         }// end of nested if/else   
      }// end of primary if/else statement
      return current;
   }// end of askQuestions method
   
   // boolean method for asking the user a question,
   // which is forced to an answer of "y" or "n"
   // returns true on "y" (forced from "yes"), returns false otherwise
   public boolean toYes(String prompt) {
      System.out.print(prompt + " (y/n)? ");
      String response = console.nextLine().trim().toLowerCase();
      while (!response.equals("y") && !response.equals("n")) {
          System.out.println("Please answer y or n.");
          System.out.print(prompt + " (y/n)? ");
          response = console.nextLine().trim().toLowerCase();
      }// end of while
      return response.equals("y");
   }//end of toYes method
   
   // method for determining whether or not a specific node
   // is an "answer" node, or a leaf node
   private boolean isAnswerNode(QuestionNode node) {
      return (node.yesNode == null || node.noNode == null);
   }// end of isAnswerNode method
}// end of class












