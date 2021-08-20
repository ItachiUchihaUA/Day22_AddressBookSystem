package day22;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
	
	static ArrayList<Contact> addressBook = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!");
		addContact();
	}
	
	static public void addContact() {
		int flag=0;
		while(flag ==0) {
			Contact c = new Contact();
			Scanner sc = new Scanner(System.in); 
			System.out.println("---New Contact---");
			System.out.println("Enter First Name: ");
			c.setFirstName(sc.next());
			System.out.println("Enter Last Name: ");
			c.setLastName(sc.next());
			System.out.println("Enter Address: ");
			c.setAddress(sc.next());
			System.out.println("Enter City: ");
			c.setCity(sc.next());
			System.out.println("Enter State: ");
			c.setState(sc.next());
			System.out.println("Enter Zip code: ");
			c.setZip(sc.next());
			System.out.println("Enter Phone: ");
			c.setPhone(sc.next());
			addressBook.add(c);
			System.out.println("Want to Add more? Enter 1 for Yes or 2 for No :");
			flag = sc.nextInt();
		}
	}

}
