package ch.tbz.alishasfactory.model;

/**
 * IceCreamComponent is an abstract class and defines what an ice cream
 * component is. All components of an ice cream must extend this class.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-02
 *
 */

public abstract class IceCreamComponent {
	private String name;
	private double price;

	/**
	 * Protected Constructor - Not able to be called from everywhere, no empty
	 * components should exist.
	 */
	protected IceCreamComponent() {
		super();
	}

	/**
	 * Constructor - Initializes name und price of the component.
	 * 
	 * @param name
	 * @param price
	 */
	public IceCreamComponent(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * Returns name of component.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns name of component.
	 * 
	 * @return String
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns name of component.
	 * 
	 * @return String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns name of component.
	 * 
	 * @return String
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
