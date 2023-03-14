/* This class provides getter and setter methods
   for user inputs. It also provides an override
   to display node value fields as a string to be
   more user-friendly to read.*/
   
public class LNode {

   // Private variables for input fields
	private String name;
	private String address;
	private String phoneNumber;
	private LNode next;
	
	
	// creates an instance of LNode while 
   // setting next to 'null'
	public LNode() {
		next = null;
	}

	// getters and setters for inputs of names, addresses,
   // phone numbers and LNode
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LNode getNext() {
		return next;
	}

	public void setNext(LNode next) {
		this.next = next;
	}

   // override used to display the node value
   // as a UI-friendly string
	@Override
	public String toString() {
		return "Name = " + name + ", Address = " + address + ", Phone Number = "
				+ phoneNumber;
	}
}// end of LNode class
