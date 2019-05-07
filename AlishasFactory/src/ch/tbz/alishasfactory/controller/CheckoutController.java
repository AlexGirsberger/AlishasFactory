package ch.tbz.alishasfactory.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.tbz.alishasfactory.Main;
import ch.tbz.alishasfactory.model.IceCream;
import ch.tbz.alishasfactory.model.Topping;
import ch.tbz.alishasfactory.model.UserCreation;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * Checkout Controller for the checkout.fxml file.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-08
 *
 */

public class CheckoutController implements Initializable {
	
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	
	private UserCreation userCreation;
	private IceCream iceCream;
	private Text text;

	@FXML
	private Text getIceCreamName;

	@FXML
	private Text getContainerText;

	@FXML
	private Text getContainerPrice;

	@FXML
	private Text getSizeText;

	@FXML
	private Text getSizePrice;

	@FXML
	private Text getFlavorText;

	@FXML
	private Text getFlavorPrice;

	@FXML
	private Text getSauceText;

	@FXML
	private Text getSaucePrice;

	@FXML
	private TextFlow getToppingsText;

	@FXML
	private Text getToppingsPrice;

	@FXML
	private Button payButton;

	@FXML
	private TextField showTotal;

	/**
	 * Set User Creation
	 * 
	 * @param username, iceCream
	 */
	public void setUserCreation(String username, IceCream iceCream) {
		this.iceCream = iceCream;
		userCreation = new UserCreation(username);
		userCreation.addIceCream(iceCream);
		LOGGER.info("Set user creation of: " + username + ".");
	}

	/**
	 * Set Fields
	 */
	public void setFields() {

		// Ice Cream Name
		getIceCreamName.setText(iceCream.getName());
		// Container
		getContainerText.setText(iceCream.getContainer().getName());
		getContainerPrice.setText(iceCream.getContainer().getPrice() + ".-");
		// Size
		getSizeText.setText(iceCream.getSize().getName());
		getSizePrice.setText(iceCream.getSize().getPrice() + ".-");
		// Flavor
		getFlavorText.setText(iceCream.getFlavor().getName());
		getFlavorPrice.setText(iceCream.getFlavor().getPrice() + ".-");
		// Sauce
		getSauceText.setText(iceCream.getSauce().getName());
		getSaucePrice.setText(iceCream.getSauce().getPrice() + ".-");
		// Toppings
		getToppingsText.setTextAlignment(TextAlignment.CENTER);
		getToppingsText.setLineSpacing(0.5);
		ObservableList list = getToppingsText.getChildren();
		for (Topping topping : iceCream.getToppings()) {
			text = new Text(topping.getName() + " ");
			list.add(text);
		}
		getToppingsPrice.setText(iceCream.getToppingPrice() + ".-");
		// Show Total
		showTotal.setText(iceCream.getPrice() + ".-");
	}

	/**
	 * Initialize Checkout Window.
	 */
	@Override
	public void initialize(URL location, ResourceBundle recources) {

		assert getIceCreamName != null : "fx:id=\"getIceCreamName\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getContainerText != null : "fx:id=\"getContainerText\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getContainerPrice != null : "fx:id=\"getContainerPrice\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getSizeText != null : "fx:id=\"getSizeText\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getSizePrice != null : "fx:id=\"getSizePrice\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getFlavorText != null : "fx:id=\"getFlavorText\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getFlavorPrice != null : "fx:id=\"getFlavorPrice\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getSauceText != null : "fx:id=\"getSauceText\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getSaucePrice != null : "fx:id=\"getSaucePrice\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getToppingsText != null : "fx:id=\"getToppingsText\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert getToppingsPrice != null : "fx:id=\"getToppingsPrice\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert payButton != null : "fx:id=\"payButton\" was not injected: check your FXML file 'Checkout.fxml'.";
		assert showTotal != null : "fx:id=\"showTotal\" was not injected: check your FXML file 'Checkout.fxml'.";
	}
}
