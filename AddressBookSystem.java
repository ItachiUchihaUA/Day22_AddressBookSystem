package day22;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
	
	static ArrayList<Contact> addressBook = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!");
		addContact();
		editContact();
		deleteContact();
	}
	
	static public void addContact() {
		int flag=0;
		while(flag ==0) {
			Contact c = new Contact();
			Scanner sc = new Scanner(System.in); 
			System.out.println("---New Contact---");
			System.out.println("Enter First Name: ");
			String firstName = sc.next();
			try {
				for(int i=0; i<addressBook.size();i++ ) {
					if(addressBook.isEmpty()) {
						break;
					}else {
						if(addressBook.get(i).equals(firstName)) {
							throw new DuplicateEntry();
						}
					}
				}
				c.setFirstName(firstName);
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
			}
			catch(DuplicateEntry e){
				System.out.println(e.getMessage());
			}
			finally {
			System.out.println("Want to Add more? Enter 1 for Yes or 2 for No :");
			flag = sc.nextInt();
			}
		}
	}
	
	static public void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name to Edit : ");
		String name = sc.next();
		int flag2 =0;
		for(int i =0; i<addressBook.size(); i++) {
			if( addressBook.get(i).getFirstName() == name ) {
				flag2=1;
				System.out.println("---Edit Contact---");
				System.out.println("Enter First Name: ");
				addressBook.get(i).setFirstName(sc.next());
				System.out.println("Enter Last Name: ");
				addressBook.get(i).setLastName(sc.next());
				System.out.println("Enter Address: ");
				addressBook.get(i).setAddress(sc.next());
				System.out.println("Enter City: ");
				addressBook.get(i).setCity(sc.next());
				System.out.println("Enter State: ");
				addressBook.get(i).setState(sc.next());
				System.out.println("Enter Zip code: ");
				addressBook.get(i).setZip(sc.next());
				System.out.println("Enter Phone: ");
				addressBook.get(i).setPhone(sc.next());
			}
		}
		if(flag2==0) {
			System.out.println("No Such Contact Found!");
		}
	}
	static public void deleteContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name to delete : ");
		String name = sc.next();
		int flag2 =0;
		for(int i =0; i<addressBook.size(); i++) {
			if( addressBook.get(i).getFirstName() == name ) {
				flag2=1;
				addressBook.remove(i);
				System.out.println("Deleted!");
			}
		}
		if(flag2==0) {
			System.out.println("No Such Contact Found!");
		}
	}
	
	static public void searchInCityOrState() {
		if(addressBook.isEmpty()) {
			System.out.println("Empty Book!");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to search in City or 2 to search in State");
		int temp= sc.nextInt();
		if(temp==1) {
			System.out.println("Enter City Name: ");
			String city=sc.next();
			for(int i =0; i<addressBook.size(); i++) {
				if(addressBook.get(i).getCity()==city) {
					System.out.println("  "+addressBook.get(i).getFirstName());
				}
			}
		}
		else if(temp==2) {
			System.out.println("Enter State Name: ");
			String State=sc.next();
			for(int i =0; i<addressBook.size(); i++) {
				if(addressBook.get(i).getState()==State) {
					System.out.println("  "+addressBook.get(i).getFirstName());
				}
			}
		}
		else {
			System.out.println("Enter 1 or 2 only!");
			searchInCityOrState();
		}
	}
	
}

class DuplicateEntry extends Exception{
	@Override
	public String getMessage() {
		return "Duplicate Entry";
	}
}
