package BlackjackLab;

// Contains the different number values (faces) and names for cards
// 1 - 10 have values equal to their number
// Jack, King, and Queen worth 10, Aces worth 11
// Aces will be counted as 1 OR 11 in other classes

public enum Face {
   ACE("Ace", 11),
   TWO("Two", 2),
   THREE("Three", 3),
   FOUR("Four", 4),
   FIVE("Five", 5),
   SIX("Six", 6),
   SEVEN("Seven", 7),
   EIGHT("Eight", 8),
   NINE("Nine", 9),
   TEN("Ten", 10),
   JACK("Jack", 10),
   QUEEN("Queen", 10),
   KING("King", 10);
   
   //Gives each face value a name, and an int for storing card value
   String faceName;
   int faceValue;
   
   //Constructor for Face enum
   Face(String faceName, int faceValue) {
      this.faceName = faceName;
      this.faceValue = faceValue;
   }// end of Value constructor
   
   //method to return the cardName value
   public String toString() {
      return faceName;
   }// end of toString method
}