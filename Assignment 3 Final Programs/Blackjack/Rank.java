// Contains the different number values (ranks) and names for cards
// 1 - 10 have values equal to their number
// Jack, King, and Queen worth 10, Aces worth 11
// Aces will be counted as 1 OR 11 in other classes

public enum Rank {
    ACE("Ace", 11),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four",4),
    FIVE("Five",5),
    SIX("Six",6),
    SEVEN("Seven",7),
    EIGHT("Eight",8),
    NINE("Nine",9),
    TEN("Ten",10),
    JACK("Jack",10),
    QUEEN("Queen",10),
    KING("King",10);

    String rankName;
    int rankValue;

    // constructor for the Rank enum 
    // each Rank has a name and a value
    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }// end of Rank constructor

    // returns the name of the Rank value
    public String toString(){
        return rankName;
    }
}
