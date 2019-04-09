package ch.tbz.alishasfactory.model;

/**
 * Flavor is an IceCream component and has predefined instances of it's class.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-02
 *
 */

public class Flavor extends IceCreamComponent {

	private Flavor chocolate;
	private Flavor strawberry;
	private Flavor vanilla;
	private Flavor stracciatella;
	private Flavor mocca;
	private Flavor mango;
	private Flavor coconut;
	private Flavor yogurt;

	/**
	 * Private Constructor - Called to create objects
	 * 
	 * @param name
	 * @param price
	 */
	private Flavor(String name, double price) {
		super(name, price);
	}

	/**
	 * Constructor - Initializes eight objects by calling another constructor
	 */
	public Flavor() {
		super();
		chocolate = new Flavor("Chocolate", 1.50);
		strawberry = new Flavor("Strawberry", 1.50);
		vanilla = new Flavor("Vanilla", 1.50);
		stracciatella = new Flavor("Stracciatella", 2.00);
		mocca = new Flavor("Mocca", 2.00);
		mango = new Flavor("Mango", 2.00);
		coconut = new Flavor("Coconut", 2.00);
		yogurt = new Flavor("Yogurt", 1.50);
	}

	/**
	 * Returns chocolate Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getChocolate() {
		return chocolate;
	}

	/**
	 * Returns strawberry Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getStrawberry() {
		return strawberry;
	}

	/**
	 * Returns vanilla Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getVanilla() {
		return vanilla;
	}

	/**
	 * Returns stracciatella Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getStracciatella() {
		return stracciatella;
	}

	/**
	 * Returns mocca Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getMocca() {
		return mocca;
	}

	/**
	 * Returns mango Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getMango() {
		return mango;
	}

	/**
	 * Returns coconut Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getCoconut() {
		return coconut;
	}

	/**
	 * Returns yogurt Flavor
	 * 
	 * @return Flavor
	 */
	public Flavor getYogurt() {
		return yogurt;
	}

}
