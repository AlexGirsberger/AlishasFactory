package ch.tbz.alishasfactory.model;

/**
 * Sauce is an IceCream component and has predefined instances of it's class.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-02
 *
 */

public class Sauce extends IceCreamComponent {
	private Sauce chocolate;
	private Sauce strawberry;
	private Sauce caramel;

	/**
	 * Private Constructor - Called to create objects
	 * 
	 * @param name
	 * @param price
	 */
	private Sauce(String name, double price) {
		super(name, price);
	}

	/**
	 * Constructor - Initializes three objects by calling another constructor
	 */
	public Sauce() {
		super();
		chocolate = new Sauce("Chocolate", 1.00);
		strawberry = new Sauce("Strawberry", 1.00);
		caramel = new Sauce("Caramel", 1.00);
	}

	/**
	 * Returns chocolate Sauce
	 * 
	 * @return Sauce
	 */
	public Sauce getChocolate() {
		return chocolate;
	}

	/**
	 * Returns strawberry Sauce
	 * 
	 * @return Sauce
	 */
	public Sauce getStrawberry() {
		return strawberry;
	}

	/**
	 * Returns caramel Sauce
	 * 
	 * @return Sauce
	 */
	public Sauce getCaramel() {
		return caramel;
	}

}
