import java.util.*;

/* Cart holds all the items that the shopper is deciding to buy. The shopper can add and remove items from their cart.*/
public class Cart {
	private List<Item> basket = new ArrayList<Item>();
	
	public Cart() {
	}
	
	public int add(Item item) {
		if(item == null) {
			return -1;
		}
		basket.add(item);
		return 0;
	}
	
	public boolean remove(Item item) {
		if (item == null) {
			return false;
		}
		return basket.remove(item);
	}
	
}
