/* This class provides methods for the following functions:

   Method for adding add names, addresses, 
   and phone numbers to a linked list based on user input
   
   Method for printing a current list of entries.
   
   Boolean method used in the event of an empty list.
   
   Method to search through names in a string.
   
   Boolean method to search through the list for addresses,
   returning as true when matching user input.
   
   Method to delete entries according to their index number.*/
   
public class LnkList {

	private LNode head;
	private int length;

	// constructor for initializing linked list
	public LnkList() {
		head = null;
		length = 0;
	}// end of constructor

	// Method to add a name, address, and phonenumber
   // In a string form
	public void add(String name, String address, String phoneNumber) {

		LNode current = head;
		LNode previous = null;
		LNode newNode = new LNode();
      
		// Set the data
		newNode.setName(name);
		newNode.setAddress(address);
		newNode.setPhoneNumber(phoneNumber);

		// if a node head is empty, this if/else statement has
      // a new entry automatically become the head
		// while increasing the node's length by one
		if (isEmpty()) {
			head = newNode;
			length++;
		} else {

			// for loop compares last names of entries for priority
			// by first letter in last name
			for (int i = 0; i < length; i++) {
				String[] ourNames1 = current.getName().split(" ");
				String[] ourNames2 = newNode.getName().split(" ");

				int result = ourNames1[ourNames1.length-1].
                        compareToIgnoreCase(ourNames2[ourNames2.length-1]);

				// if last name entered goes before what's stored in
				// the head, the new entry becomes the head
				if (result > 0) {
					if (previous == null) {
						newNode.setNext(current);
						head = newNode;
						length++;
						break;
					}

					// this section cycles through the "body" of the nodes if 
					// it's not the tail
					previous.setNext(newNode);
					newNode.setNext(current);
					length++;
					break;
				}// end of "last name" if statement
            
            // "else" condition denotes that if an entry replaces
            // a tail node, this entry becomes the new tail
				else {
					if (current.getNext() == null) {
						current.setNext(newNode);
						newNode.setNext(null);
						length++;
						break;
					}
					// System.out.println("Add after");
					previous = current;
					current = current.getNext();
				}// end of new tail condition
			}// end of for loop
		}// end of first else condition
	}// end of Add method

   // method for printing the list of entries
	public void printList () {

		// starts at the node head to check 
      // if anything is there
		LNode tempNode = head;
      
      // if/else statement uses a for loop to
      // go through the entry list and print
      // it in order
		if (head == null) {
			System.out.println("There are currently no entries!");
		} else {
			for (int i = 0; i < length; i++) {
				System.out.print("Index = " + (i+1) + " ");
				System.out.println(tempNode);
				tempNode = tempNode.getNext();
			}// end of for loop

		}// end of if/else statement
		System.out.println();
	}// end of printList method

	// boolean method used in the event
   // of an empty list
	public boolean isEmpty() {
		return (length == 0);
	}// end of isEmpty method

	// this method searches through the names
   // in the string
	public void nameSearch(String name) {
		LNode current = head;
		boolean empty = true;

		// if/else statement checks to see
      // if the list is empty
		if (isEmpty()) {
			System.out.println("There are currently no entries!");
		} else {
			// for loop checks to see if input matches
         // anything in the string
			for (int i = 0; i < length; i++) {
				if (current.getName().toLowerCase().contains(name.toLowerCase())) {
					System.out.print("Index = " + (i+1) + " ");
					System.out.println(current);
					empty = false;

				}
				// if first string doesn't have desired
				// search value, goes to the next node
				current = current.getNext();
			}// end of for loop
			// if statement to show if there are no matches found
			if (empty){
				System.out.println("No matches to that name found!");
			}
		}// end of if/else statement

	}// end of nameSearch method

	// this method searches through the list for addresses,
   // returning a true boolean when it is
	public void addressSearch(String address) {
		LNode current = head;
		boolean empty = true;
		// if/else statement checks to see
      // if list is empty
		if (isEmpty()) {
			System.out.println("There are currently no entries!");
         // else condition checks the first in list to see if
		   // desired search matches first entry in list
		} else {
			for (int i = 0; i < length; i++) {
            // if nothing is in the current node,
            // if statement sets to next and
            // searches again
				if (current.getAddress().toLowerCase().contains(address.toLowerCase())) {
					System.out.print("Index = " + (i+1) + " ");
					System.out.println(current);
					empty = false;
				}
				current = current.getNext();
			}// end of for loop
         
			// if statement for when no addresses 
         // match the desired search
			if (empty){
				System.out.println("No matches to that address found!");
			}
		}// end of if/else statement

	}// end of addressSearch method

	// this method deletes entries
   // by their index number
	public void delete (int index) {
		LNode current = head;
		LNode previous = null;
		boolean empty = true;
		// if statement checks to see 
      // if list is empty
		if (isEmpty()) {
			System.out.println("There are currently no entries!");
        // else condition iterates over,
        // finds the index and deletes it
		} else {
			for (int i = 0; i < length; i++) {
				if ((index-1) == i) {
					if (previous == null) {
						head = head.getNext();
						length--;
						empty = false;
						break;
					} else if (current.getNext() == null){
						previous.setNext(null);
						length--;
						empty = false;
						break;
					} else {
						previous.setNext(current.getNext());
						length--;
						empty = false;
						break;
					}
				} else {
					previous = current;
					current = current.getNext();
				}
			}
         // if/else statement alerts if an index is not found,
         // or is successfully deleted
			if (empty){
				System.out.println("Index Does Not Exist!");
			} else {
				System.out.println("Successfully deleted index " + index);
			}
		}// end of if/else statement

	}// end of "delete" method

}// end of LnkList class
