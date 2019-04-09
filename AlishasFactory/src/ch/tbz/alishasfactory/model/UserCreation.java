package ch.tbz.alishasfactory.model;

import java.util.ArrayList;

/**
 * User Creation saves the icecreams a user created in a list and the total
 * price is saved as well.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-08
 *
 */

public class UserCreation {
	private String username;
	private ArrayList<IceCream> iceCreams;
	private Double totalPrice;

	/**
	 * Constructor 1 - This Constructor is called when the User has already created
	 * an ice cream.
	 *
	 * @param username
	 * @param iceCream
	 */
	public UserCreation(String username, IceCream iceCream) {
		this.username = username;
		this.iceCreams = new ArrayList<IceCream>();
		iceCreams.add(iceCream);
	}

	/**
	 * Constructor 2 - This Constructor is called when there's no ice cream creation
	 * of a User.
	 * 
	 * @param username
	 */
	public UserCreation(String username) {
		this.username = username;
		this.iceCreams = new ArrayList<IceCream>();
		this.totalPrice = 0.0;
	}

	/**
	 * Returns username.
	 * 
	 * @return String
	 */
	public String getUserName() {
		return username;
	}

	/**
	 * Returns ArrayList of IceCreams that User has added.
	 * 
	 * @return ArrayList<IceCream>
	 */
	public ArrayList<IceCream> getUserIceCreams() {
		return iceCreams;
	}

	/**
	 * Updates and then returns total price.
	 * 
	 * @return double
	 */
	public Double getTotalPrice() {
		totalPrice = 0.0;
		for (IceCream iceCream : iceCreams) {
			totalPrice = totalPrice + iceCream.getPrice();
		}

		return totalPrice;
	}

	/**
	 * Add ice cream to ArrayList and calls method to update total price.
	 * 
	 * @param iceCream
	 */
	public void addIceCream(IceCream iceCream) {
		iceCreams.add(iceCream);
		totalPrice = getTotalPrice();
	}
}
