import java.util.*;
/* Store keeps track of all of the items and brands stocked. Items and Brands are stored in a list. */
public class Store {
	private List<Item> items = new ArrayList<Item>();
	private List<Brand> brands = new ArrayList<Brand>();
	
	public Store () {};
	
	/**
	 * Adds an item to the store
	 * @param item
	 * @return
	 */
	public int addItem(Item item) {
		if (item == null) {
			return -1;
		}
		items.add(item);
		return 0;
	}
	/**
	 * Adds a brand to the store
	 * @param brand
	 * @return
	 */
	public int addBrand(Brand brand) {
		if (brand == null) {
			return -1;
		}
		brands.add(brand);
		return 0;
	}
	/**
	 * Removes an item from the store
	 * @param item
	 * @return
	 */
	public boolean removeItem(Item item) {
		return items.remove(item);
	}
	/**
	 * Removes a brand from the store.
	 */
	public boolean removeBrand(Brand brand) {
		return brands.remove(brand);
	}
	
	/**
	 * Checks if an item or brand is contained in the store
	 */
	public boolean contains(Object o) {
		if (o instanceof Item) {
			return items.contains((Item)o);
		}
		else if (o instanceof Brand) {
			return brands.contains((Brand)o);
		}
		return false;
	}
	/**
	 * Returns a list of all the items in the store.
	 */
	public List<Item> getItems() {
		return items;
	}
}
