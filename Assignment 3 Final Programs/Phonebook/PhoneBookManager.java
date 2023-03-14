// Programmer: Blake Nelson
// Class: CS 145
// Date: February 10, 2023
// Assignment 2: Phonebook
/* This program allows a user to edit entries within a phonebook,
   by method of linked lists.
   Through a console menu, users may add new entries,
   delete entries, search for entries by name or address,
   and view the current list of entries within the list.*/

import java.util.*;


public class PhoneBookManager {

	public static void main(String[] args) {

		LnkList newList = new LnkList();
		Scanner in = new Scanner(System.in); 
		String fileName = "";

		String menu;
		boolean done = false;

		do {
			System.out.println();
			System.out.format("* * *%n");
			System.out.format("1 - Add  an entry\n2 - Delete an entry \n3 - Search by Name \n"); 
         System.out.format("4 - Search by Address \n5 - View Contacts \nPress Q to (Q)uit%n");	
			System.out.format("* * *%n");
			System.out.format("Please Enter a command: ");
			menu = in.nextLine().toUpperCase();

         // Switch case statement for reading user inputs
			switch (menu) {
				case "1": 
					System.out.println("Add an entry");
					
					System.out.print("Please enter a first and last name: ");
					String name = in.nextLine();

					System.out.print("Please enter a street address: ");
					String address = in.nextLine();

					System.out.print("Plese enter a phone number: ");
					String phoneNumber = in.nextLine();
	
					newList.add(name, address, phoneNumber); 
					break;
               
				case "2": 
					System.out.print("Please enter index number to delete: ");
					int delete = in.nextInt();
					newList.delete(delete);
					break;
               
				case "4": 
					System.out.print("Please enter an ADDRESS to search for: ");
					String sAddress = in.nextLine();
					newList.addressSearch(sAddress);
					break;
                
				case "5": 
					System.out.println("List of entries:");
					newList.printList();
					break; 
               
            case "3": 
					System.out.print("Please enter a NAME to search for: ");
					String sName = in.nextLine();
					newList.nameSearch(sName);
					break; 
               
				case "Q": 
					System.out.println("Closing. Goodbye!");
					done = true;
					break;
				default: 
					System.out.println("Unknown entry");
			}// end of switch/case

		}  while (!done); //end of do/while

	}// end of main method
}