package ch.tbz.alishasfactory.model;

/**
 * Sauce is an IceCream component and has predefined instances of it's class.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-02
 *
 */

public class Topping extends IceCreamComponent {
	private Topping chocolateChips;
	private Topping brownies;
	private Topping cookies;
	private Topping waffle;
	private Topping smarties;
	private Topping nuts;
	private Topping gummyBears;
	private Topping nutella;
	private Topping whippedCream;
	private Topping cereals;
	private Topping berries;
	private Topping meringues;

	/**
	 * Private Constructor - Called to create objects
	 * 
	 * @param name
	 * @param price
	 */
	private Topping(String name, double price) {
		super(name, price);
	}

	/**
	 * Constructor - Initializes twelve objects by calling another constructor
	 */
	public Topping() {
		super();
		chocolateChips = new Topping("Chocolate Chips", 0.50);
		brownies = new Topping("Brownies", 1.00);
		cookies = new Topping("Cookies", 1.00);
		waffle = new Topping("Waffle", 1.50);
		smarties = new Topping("Smarties", 0.50);
		nuts = new Topping("Nuts", 2.00);
		gummyBears = new Topping("Gummy Bears", 1.00);
		nutella = new Topping("Nutella", 2.00);
		whippedCream = new Topping("Whipped Cream", 1.50);
		cereals = new Topping("Cereals", 1.00);
		berries = new Topping("Berries", 2.50);
		meringues = new Topping("Meringues", 1.50);

	}

	/**
	 * Returns chocolateChips Topping
	 * 
	 * @return Topping
	 */
	public Topping getChocolateChips() {
		return chocolateChips;
	}

	/**
	 * Returns brownies Topping
	 * 
	 * @return Topping
	 */
	public Topping getBrownies() {
		return brownies;
	}

	/**
	 * Returns cookies Topping
	 * 
	 * @return Topping
	 */
	public Topping getCookies() {
		return cookies;
	}

	/**
	 * Returns waffle Topping
	 * 
	 * @return Topping
	 */
	public Topping getWaffle() {
		return waffle;
	}

	/**
	 * Returns smarties Topping
	 * 
	 * @return Topping
	 */
	public Topping getSmarties() {
		return smarties;
	}

	/**
	 * Returns nuts Topping
	 * 
	 * @return Topping
	 */
	public Topping getNuts() {
		return nuts;
	}

	/**
	 * Returns gummyBears Topping
	 * 
	 * @return Topping
	 */
	public Topping getGummyBears() {
		return gummyBears;
	}

	/**
	 * Returns nutella Topping
	 * 
	 * @return Topping
	 */
	public Topping getNutella() {
		return nutella;
	}

	/**
	 * Returns whippedCream Topping
	 * 
	 * @return Topping
	 */
	public Topping getWhippedCream() {
		return whippedCream;
	}

	/**
	 * Returns cereals Topping
	 * 
	 * @return Topping
	 */
	public Topping getCereals() {
		return cereals;
	}

	/**
	 * Returns berries Topping
	 * 
	 * @return Topping
	 */
	public Topping getBerries() {
		return berries;
	}

	/**
	 * Returns meringues Topping
	 * 
	 * @return Topping
	 */
	public Topping getMeringues() {
		return meringues;
	}

}
