/*
 * Defines all the types of products in the store. 
 */
public enum Type {
	//PRODUCT TYPES
	TOYS("Toys"),
	CLOTHING("Clothing"),
	FEM_HYGIENE("Feminine Hygiene"),
	PERSONAL_CARE("Personal Care"),
	HEALTH("Health");
	
	private String name;
	private Type(String name) {
		this.name = name;
	}
	public String getName() { return name; }
	public static Type matchType(String type) {
		for (Type t : Type.values()) {
			if (t.toString().equals(type)) {
				return t;
			}
		}
		return null;
	}
}
