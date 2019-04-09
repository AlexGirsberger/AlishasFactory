package ch.tbz.alishasfactory.model;

import java.util.ArrayList;

/**
 * IceCream contains several components and also has a name. An instance of this
 * class is created by the Builder.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-08
 *
 */

public class IceCream {

	public static class Builder {
		private String name;
		private Size size;
		private Container container;
		private Flavor flavor;
		private Sauce sauce;
		private ArrayList<Topping> toppings;

		/**
		 * Builder Constructor - Needs parameter with name.
		 * 
		 * @param name
		 */
		public Builder(String name) {
			this.name = name;
		}

		/**
		 * Sets Size of Ice Cream. ¨
		 * 
		 * @param size
		 * @return this
		 */
		public Builder setSize(Size size) {
			this.size = size;
			return this;
		}

		/**
		 * Sets Container of Ice Cream.
		 * 
		 * @param container
		 * @return this
		 */
		public Builder setContainer(Container container) {
			this.container = container;
			return this;
		}

		/**
		 * Sets Flavor of Ice Cream.
		 * 
		 * @param flavor
		 * @return this
		 */
		public Builder setFlavor(Flavor flavor) {
			this.flavor = flavor;
			return this;
		}

		/**
		 * Sets Sauce of Ice Cream.
		 * 
		 * @param sauce
		 * @return this
		 */
		public Builder setSauce(Sauce sauce) {
			this.sauce = sauce;
			return this;
		}

		/**
		 * Sets Toppings of Ice Cream.
		 * 
		 * @param toppings
		 * @return this
		 */
		public Builder setToppings(ArrayList<Topping> toppings) {
			this.toppings = toppings;
			return this;
		}

		/**
		 * Build an instance of IceCream and returns it.
		 * 
		 * @return IceCream
		 */
		public IceCream build() {
			IceCream iceCream = new IceCream();
			iceCream.name = this.name;
			iceCream.size = this.size;
			iceCream.container = this.container;
			iceCream.flavor = this.flavor;
			iceCream.sauce = this.sauce;
			iceCream.toppings = this.toppings;

			return iceCream;
		}

	}

	private String name;
	private Size size;
	private Container container;
	private Flavor flavor;
	private Sauce sauce;
	private ArrayList<Topping> toppings;
	private double price = 0.0;

	/**
	 * Private Constructor
	 */
	private IceCream() {
	}

	/**
	 * Get name of IceCream
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get size of IceCream
	 * 
	 * @return Size
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Get container of IceCream
	 * 
	 * @return Container
	 */
	public Container getContainer() {
		return container;
	}

	/**
	 * Get flavor of IceCream
	 * 
	 * @return Flavor
	 */
	public Flavor getFlavor() {
		return flavor;
	}

	/**
	 * Get sauce of IceCream
	 * 
	 * @return Sauce
	 */
	public Sauce getSauce() {
		return sauce;
	}

	/**
	 * Get toppings of IceCream
	 * 
	 * @return ArrayList<Topping>
	 */
	public ArrayList<Topping> getToppings() {
		return toppings;
	}

	/**
	 * Get toppings price of IceCream
	 * 
	 * @return double
	 */
	public double getToppingPrice() {
		Double number = 0.0;
		for (Topping topping : toppings) {
			number = number + topping.getPrice();
		}
		return number;
	}

	/**
	 * Get price of IceCream
	 * 
	 * @return double
	 */
	public double getPrice() {
		price = 0.0;
		if (!size.equals(null)) {
			price = price + size.getPrice();
		}
		if (!container.equals(null)) {
			price = price + container.getPrice();
		}
		if (!flavor.equals(null)) {
			price = price + flavor.getPrice();
		}
		if (!sauce.equals(null)) {
			price = price + sauce.getPrice();
		}
		if (!toppings.equals(null)) {
			price = price + getToppingPrice();
		}
		return price;
	}

	/**
	 * Set name of IceCream
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set size of IceCream
	 * 
	 * @param size
	 */
	public void setSize(Size size) {
		this.size = size;
	}

	/**
	 * Set container of IceCream
	 * 
	 * @param container
	 */
	public void setContainer(Container container) {
		this.container = container;
	}

	/**
	 * Set flavor of IceCream
	 * 
	 * @param flavor
	 */
	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	/**
	 * Set sauce of IceCream
	 * 
	 * @param sauce
	 */
	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	/**
	 * Set toppings of IceCream
	 * 
	 * @param toppings
	 */
	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings = toppings;
	}

	/**
	 * Set price of IceCream
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
