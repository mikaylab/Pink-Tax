/*
 * Item represents a product from the store. Each item has a price, description, brand, type, name, and ID number.  
 *
 */
public class Item extends Object {
	private double price;
	private String quantity;
	private String brand;
	private int id;
	private String name;
	private Type type;
	private Gender gender;
	
	public Item(double price, String quantity, String brand, int id, String name, Type type, Gender gender) {
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.id = id;
		this.type = type;
		this.gender = gender;
	}
	
	private Item(String quantity, String brand, Type type, Gender gender) {
		this.quantity = quantity;
		this.brand = brand;
		this.type = type;
		this.gender = gender;
	}
	
	/**
	 * Returns the price of the given item.
	 * @return	price as a double
	 */
	public double getPrice() { return price; }
	
	/**
	 * Returns the quantity of the given item.
	 * @return	quantity as a String
	 */
	public String getQuantity() { return quantity; }
	
	/**
	 * Returns the brand of an item
	 * @return	brand as a string
	 */
	public String getBrand() { return brand; }
	
	/**
	 * Sets the brand of the given item to the argument brandName
	 * @param brandName
	 */
	public void setBrand(String brandName) { brand = brandName; }
	
	/**
	 * Returns the ID of the given item
	 * @return	ID as an integer
	 */
	public int getId() { return id; }
	
	/**
	 * Returns the name of the given item
	 * @return	name as a String
	 */
	public String getName() { return name; }
	
	/**
	 * Returns the type of the given item
	 * @return	type as a string
	 */
	public String getType() { return type.toString(); }
	
	/**
	 * Returns the targeted gender for the given product.
	 * @return	name field of the enum Gender.
	 */
	public String getGender() { return gender.name; }
	
	/**
	 * Returns a hash code for the given item.
	 * @return	
	 */
	@Override public int hashCode() { 
		int result = 41;
		long _price = Double.doubleToLongBits(price);
		result = 31 * result + (int) (_price ^ (_price >>> 32));
		result = 31 * result + id;
		result = 31 * result + brand.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + quantity.hashCode();
		return result;
	}
	/**
	 * Returns the description of the given item as a combination of the name, brand, and quantity of the item.
	 * @return	description as a String
	 */
	public String getDescription() { 
		String description = "";
		description += brand + " " + name + ", " + quantity;
		return description;
	}
	
	/**
	 * Returns true if the id, price, brand, name, and quantity of o matches with the given item.
	 */
	@Override public boolean equals(Object o) {
		if (!(o instanceof Item)) {
			return false;
		}
		Item item = (Item) o;
		return item.getId() == id 
				&& (Double.compare(item.price, price) == 0 ? true : false)
				&& item.getBrand().equals(brand)
				&& item.getName().equals(name) 
				&& item.getQuantity().equals(quantity);
	}
	
	/**
	 * Returns the equivalent of the given item. The item returned has the same quantity, brand, type,
	 * and opposite targeted gender of this item. This method is used by the Brand class in order to find a 
	 * matching item to compare prices of the two items.
	 * @return	an Item 
	 */
	/*public Item getEquivalent() {
		Item match = new Item(quantity, brand, type, gender.getOpposite());
		return match;
	}*/
}
enum Gender {
	MALE("Male"), FEMALE("Female");
	String name;
	Gender(String gender) { this.name = gender; }
	public Gender getOpposite() {
		return this == Gender.MALE ? Gender.FEMALE : Gender.MALE;
	}
}
	