package ch.tbz.alishasfactory.model;

/**
 * Size is an IceCream component and has predefined instances of it's class.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-02
 *
 */

public class Size extends IceCreamComponent {
	private Size small;
	private Size medium;
	private Size large;

	/**
	 * Private Constructor - Called to create objects
	 * 
	 * @param name
	 * @param price
	 */
	private Size(String name, double price) {
		super(name, price);
	}

	/**
	 * Constructor - Initializes three objects by calling another constructor
	 */
	public Size() {
		super();
		small = new Size("Small", 1.00);
		medium = new Size("Medium", 2.00);
		large = new Size("Large", 3.00);
	}

	/**
	 * Returns small Size
	 * 
	 * @return Size
	 */
	public Size getSmall() {
		return small;
	}

	/**
	 * Returns medium Size
	 * 
	 * @return Size
	 */
	public Size getMedium() {
		return medium;
	}

	/**
	 * Returns large Size
	 * 
	 * @return Size
	 */
	public Size getLarge() {
		return large;
	}

}
