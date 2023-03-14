// Programmer: Blake Nelson
// Class: CS 145
// Date: Feb. 24, 2023
// Assignment: Lab 5: Towers of Hanoi
/* This program simulates a solution of the Towers of Hanoi puzzle
   which uses 4 discs. Using recursion, towers are represented as strings
   and int "discs" are moved in such a way that exactly one disc
   is moved at a time, and at no time will a larger disc
   be placed on a smaller disc.*/

public class TowersOfHanoi {

    public static void main(String[] args) {

        // Int for number of discs in play
        int n = 4;

        // Int value to compute the solution and number of moves
        int totalMoves = hanoi(n, "Tower 1", "Tower 2", "Tower 3");

        // Prints the total number of moves taken to end the game
        System.out.println("Total number of moves: " + totalMoves);
    }// end of main method

    // Method to represent the a a numeric value for discs
    // With 4 discs, 1 is the smallest and 4 is the largest
    // Prints out what move is made on every step
    static void move(int disc, String f, String t) {
        System.out.println("Moving disc " + disc + " from " + f + " to " + t);
    }// end of move method

    // Method to represent every pole for the towers as a string
    // String a is Tower 1, b is Tower 2, c is Tower 3
    // "movement" int represents recursive movement of discs
    // by moving "n" discs in an if statement from 
    // string a to string c, via string b
    static int hanoi(int n, String a, String b, String c) {
    
        // Int for representing the movement through recursion
        int movement = 0;

        // If statement triggers movement when possible by placing any
        // smaller discs on top of larger discs to string c when possible
        // moves will be made in string b otherwise
        // Statement is recursive in calling itself until 
        // string c contains all discs in order
        if(n > 0) {
            movement += hanoi(n - 1, a, c, b);
            move(n, a, c);
            movement += hanoi(n - 1, b, a, c);
            movement ++;
        } // end of if statement

        return movement;
    }// end of hanoi method

}