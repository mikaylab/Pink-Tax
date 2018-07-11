/*
 * Brand is a collection of Items, which are stored in a list. Includes a method to find the equivalent male Item to a 
 * female Item. 
 */
import java.util.*;

public class Brand {
	private String name;
	private HashMap<Integer,Item> items = new HashMap<Integer,Item>();
	
	public Brand (String name) {
		this.name = name;
	}
	/**
	 * Returns the name of the brand
	 * @return String name
	 */
	public String getName() { return name; }
	
	/**
	 * Add a new Item to the Brand. Returns 0 if item successfully added, otherwise -1.
	 * @param item
	 * @return 0 if success, -1 if failure
	 */
	public int addItem(Item item) {
		if (item == null) { return -1; }
		items.put(Integer.valueOf(item.getId()), item);
		item.setBrand(name);
		return 0;
	}
	/**
	 * Returns the Item in the brand based on its key in the items map
	 * @param key
	 * @return Item with given key
	 */
	public Item getItem(int key) {
		return items.get(Integer.valueOf(key));
	}
	/**
	 * Removes an items from the brand.
	 * @param i
	 * @return true if removal was successful
	 */
	public boolean removeItem(Item i) {
		i.setBrand(""); // Clear the brand of the item
		return items.remove(Integer.valueOf(i.getId()), i);
	}

	/**
	 * Return the match to an item in the Brand. If the item is null, not included in Brand, or no match exists, then 
	 * null is returned. 
	 * @param item
	 * @return Item if match exists, otherwise null.
	 */
	public Item findMatch(Item item) {
		if (!items.containsKey(item.getId()) || item == null) {
			return null;
		}
		// Find item based on if it is equivalent to the argument. Return the item if match found
		for (Item i: items.values()) {
			if (i.isEquivalent(item)) {
				return i;
			}
		}
		return null;
	}
}
