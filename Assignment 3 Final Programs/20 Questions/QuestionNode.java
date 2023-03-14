// Blake Nelson
// Class: CS 145
// Date: March 10, 2023
// Assignment: Lab 6: 20 Questions

/* This class implements the binary tree system used
   for the game, which is based on yes/no responses 
   as well as constructors.*/

public class QuestionNode {
   // string which holds either an object, or
   // a question corresponding to that object
   public String guessData;
   // yesNode represents the left branch of the tree, the "yes" choice
   // noNode represents the right branch, the "no" choice
   public QuestionNode yesNode;
   public QuestionNode noNode;
   
   // constructor for a leaf node using given data
   // works as an "answer" node which stores an answer
   public QuestionNode(String guessData) {
      this(guessData,null, null); 
   }// end of QuestionNode constructor 1
   
   // constructor for a branch node using given data
   // to represent left and right subtrees
   // works as a "question" which stores a question
   public QuestionNode(String guessData, QuestionNode yesNode,
                      QuestionNode noNode) {
      this.guessData = guessData;
      this.yesNode = yesNode;
      this.noNode = noNode; 
   }// end of QuestionNode constructor 2              
}// end of class