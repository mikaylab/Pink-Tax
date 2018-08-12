import java.util.*;
/*
 * The entire shopping experience is handled in this file: browsing items, checkout, and printing the receipt. All of 
 * these stages are separated into methods. 
 */
public class ShoppingMain {
		static Store store = new Store();
		
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SalesTax shopState = null;
		String option = null;
		StringBuilder sb_states = new StringBuilder("");
		
		System.out.print("Welcome Standard Online Retailer!\n-----Let's start shopping------\n");
		
		SalesTax[] states = SalesTax.values();
		
		for (int i = 0; i < 51; i++) {
			sb_states = sb_states.append(states[i].toString().trim() + "\n");
		}
		sb_states = sb_states.append("\r");
		
		System.out.println("Where are you shopping from today?\n" + sb_states);
		
		System.out.print("I'm shopping in: ");
		String selectedState = scn.next().trim();
		
		//Check that state is valid
		for (SalesTax st : SalesTax.values()) {
			if (st.toString().equalsIgnoreCase(selectedState)) {
				shopState = st;
			}
		}
		if (shopState == null) {
			System.out.println("Sorry we don't have a shopping experience for " + selectedState + ".");
			scn.close(); // close scanner
			return;
		}
		System.out.println("You are shopping in: " + shopState.toString());
		
		//Main Menu
		System.out.println("------------------------------------ MAIN MENU ------------------------------------" +
							"\nEnter the number of one of the options below to start your shopping experience:\n" +
							"1:Browse catalog\n2:Checkout cart\n3:Exit");
		
		option = scn.next().trim();
		switch (option) {
			case "1" :	displayItems("Shelf1.txt");
						break;
			case "2" : 	checkoutItems();
						break;
			case "3" :	break;
			default : {
				System.out.println("Error: Unknown option. Please enter in a number that is valid");
			}
		}
		scn.close(); // close scanner
		System.out.println("Thank you for shopping at Standard Online Retailer!");
	}
	
	
	/**
	 * Creates the items in the store by parsing the text file. Each line of the text file has all the information 
	 * for one item in the following form: Brand, Category/Type, Description, Gender, (Quantity), Price.
	 * Clothing items and toys will not include a quantity.
	 */
	public static void createStore(String filename) {
		//Parse the text file and build an Item based on the type 
		Scanner fscan = new Scanner(filename);
		String str = null;
		
		
		if (fscan.nextLine() == null) {
			System.out.println("Error reading " + filename);
			fscan.close();
			return;
		}
		
		while (fscan.hasNextLine()) {
			Gender gender = null;
			Type type = null;
			
			// You first get the brand, so first create a new brand if it doesn't already exist
			str = fscan.nextLine().trim();
			String[] line = str.split(",");
			String brand = line[0].trim();
			Brand nw_brand = new Brand(brand);
			
			String _type = line[1].trim();
			type = Type.matchType(_type);
			String name = line[2].trim();
			
			String _gender = line[3].trim();
			gender = _gender.equalsIgnoreCase(Gender.FEMALE.toString()) ? Gender.FEMALE : Gender.MALE;
			String quantity = line[4].trim();
			double price = Double.parseDouble(line[5].trim());
			int id = Integer.parseInt(line[6].trim());
			
			//if brand already exist, then create item and add to brand and store
			if (store.contains(nw_brand)) {
				Item item = new Item(price, quantity, brand, id, name, type, gender);
				store.addItem(item);
			}
			else {
				Item item = new Item(price, quantity, brand, id, name, type, gender);
				store.addItem(item);
				store.addBrand(nw_brand);
			}
		}
		fscan.close();
	}
	
	/**
	 * Displays all the items in the store in the console. Customer can put items in their cart by inputting the
	 * number of the item. 
	 */
	public static void displayItems(String filename) {
		createStore(filename);
		//List items based on their ids and have the user type in the number of the items they want delimited by commas.
		System.out.println("------------- STANDARD STORE CATALOG ----------------\nEnter in the ID of the item you want "
				+ "to add to your cart, or list the items you want to add to your cart by separating each item "
				+ "using commas." + "Example: '####' or '####, ####, ####'");
		for (Item i : store.getItems()) {
			
		}
	}
	public static void checkoutItems() {
		
	}
	public static void printReceipt() {
		
	}
}
