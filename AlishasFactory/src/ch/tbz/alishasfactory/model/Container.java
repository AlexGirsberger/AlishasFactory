package ch.tbz.alishasfactory.model;

/**
 * Container is an IceCream component and has predefined instances of it's
 * class.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-02
 *
 */

public class Container extends IceCreamComponent {

	private Container cone;
	private Container cup;

	/**
	 * Private Constructor - Called to create objects
	 * 
	 * @param name
	 * @param price
	 */
	private Container(String name, double price) {
		super(name, price);
	}

	/**
	 * Constructor - Initializes two objects by calling another constructor
	 */
	public Container() {
		super();
		cone = new Container("Cone", 1.50);
		cup = new Container("Cup", 1.00);
	}

	/**
	 * Returns cone Container
	 * 
	 * @return Container
	 */
	public Container getCone() {
		return cone;
	}

	/**
	 * Returns cup Container
	 * 
	 * @return Container
	 */
	public Container getCup() {
		return cup;
	}

}
