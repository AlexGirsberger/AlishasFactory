package ch.tbz.alishasfactory.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.tbz.alishasfactory.Main;
import ch.tbz.alishasfactory.model.Container;
import ch.tbz.alishasfactory.model.Flavor;
import ch.tbz.alishasfactory.model.IceCream;
import ch.tbz.alishasfactory.model.IceCreamComponent;
import ch.tbz.alishasfactory.model.Sauce;
import ch.tbz.alishasfactory.model.Size;
import ch.tbz.alishasfactory.model.Topping;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 * Create Controller for the create.fxml file. Calls the Checkout Controller and
 * it's FXML file.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-08
 *
 */

public class CreateController implements Initializable {
	
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	static private String CHECKOUT_FXML = "../view/Checkout.fxml";

	private String username;
	private String iceCreamName;
	private IceCream iceCream;
	private Sauce sauceModel = new Sauce();
	private Size sizeModel = new Size();
	private Container containerModel = new Container();
	private Topping toppingsModel = new Topping();
	private Flavor flavorModel = new Flavor();

	// Current selected prices
	private Double currentContainerPrice = 0.0;
	private Double currentSizePrice = 0.0;
	private Double currentFlavorPrice = 0.0;
	private Double currentSaucePrice = 0.0;
	private Double currentToppingsPrice = 0.0;
	private Double currentTotalPrice = 0.0;

	// Current selected components
	private Container currentContainer = null;
	private Size currentSize = null;
	private Flavor currentFlavor = null;
	private Sauce currentSauce = null;
	private ArrayList<Topping> currentToppings = new ArrayList<Topping>();


    @FXML
    private TextField iceCreamNameTextField;
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField showTotal;

	// Container group
	@FXML
	private ToggleGroup container;
	@FXML
	private RadioButton coneContainerRadioButton;
	@FXML
	private RadioButton cupContainerRadioButton;

	// Size group
	@FXML
	private ToggleGroup size;
	@FXML
	private RadioButton smallSizeRadioButton;
	@FXML
	private RadioButton mediumSizeRadioButton;
	@FXML
	private RadioButton largeSizeRadioButton;

	// Flavor group
	@FXML
	ToggleGroup flavor;
	@FXML
	private RadioButton chocolateFlavorRadioButton;
	@FXML
	private RadioButton coconutFlavorRadioButton;
	@FXML
	private RadioButton mangoFlavorRadioButton;
	@FXML
	private RadioButton moccaFlavorRadioButton;
	@FXML
	private RadioButton stracciatellaFlavorRadioButton;
	@FXML
	private RadioButton strawberryFlavorRadioButton;
	@FXML
	private RadioButton vanillaFlavorRadioButton;
	@FXML
	private RadioButton yogurtFlavorRadioButton;

	// Sauce group
	@FXML
	private ToggleGroup sauce;
	@FXML
	private RadioButton chocolateSauceRadioButton;
	@FXML
	private RadioButton caramelSauceRadioButton;
	@FXML
	private RadioButton strawberrySauceRadioButton;

	// Topping group
	@FXML
	private CheckBox berriesToppingCheckBox;
	@FXML
	private CheckBox browniesToppingCheckBox;
	@FXML
	private CheckBox cerealsToppingCheckBox;
	@FXML
	private CheckBox chocolatechipsToppingCheckBox;
	@FXML
	private CheckBox cookiesToppingCheckBox;
	@FXML
	private CheckBox gummybearsToppingCheckBox;
	@FXML
	private CheckBox meringuesToppingCheckBox;
	@FXML
	private CheckBox nutellaToppingCheckBox;
	@FXML
	private CheckBox nutsToppingCheckBox;
	@FXML
	private CheckBox smartiesToppingCheckBox;
	@FXML
	private CheckBox waffleToppingCheckBox;
	@FXML
	private CheckBox whippedcreamToppingCheckBox;

	/**
	 * Get Ice Cream
	 * 
	 * @return Ice Cream
	 */
	public IceCream getIceCream() {
		return iceCream;
	}

	/**
	 * Create Ice Cream.
	 */
	public void createIceCream() {
		iceCream = new IceCream.Builder(iceCreamName).setContainer(currentContainer).setSize(currentSize)
				.setFlavor(currentFlavor).setSauce(currentSauce).setToppings(currentToppings).build();
		LOGGER.info("Created icecream: " + iceCream.getName() + ".");
	}

	/**
	 * Set Ice Cream name
	 * 
	 * @param iceCreamName
	 */
	public void setIceCreamName(String iceCreamName) {
		this.iceCreamName = iceCreamName;
	}
	
	/**
	 * Set username.
	 * 
	 * @param username
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * Add topping to Ice Cream
	 * 
	 * @param topping
	 */
	public void addTopping(Topping topping) {
		if (!currentToppings.contains(topping)) {
			currentToppings.add(topping);
			LOGGER.info("Added Topping: " + topping.getName() + ".");
		}

	}

	/**
	 * Remove topping from Ice Cream
	 * 
	 * @param topping
	 */
	public void removeTopping(Topping topping) {
		if (currentToppings.contains(topping)) {
			currentToppings.remove(topping);
			LOGGER.info("Removed topping: " + topping.getName() + ".");
		}
	}

	/**
	 * Update Ice Cream price.
	 */
	public void updateShowPrice() {

		String text = currentTotalPrice + ".-";
		showTotal.setStyle("-fx-text-fill: black");
		showTotal.setText(text);
		LOGGER.info("Updated price: " + currentTotalPrice + ".");

	}

	/**
	 * Updates components of IceCream.
	 * 
	 * @param <Component>
	 * @param component
	 * @return component
	 */
	public <Component extends IceCreamComponent> Component updateIceCream(Component component) {

		if (component.getClass().isInstance(containerModel)) {
			currentContainerPrice = component.getPrice();
			currentContainer = (Container) component;
			LOGGER.info("Selected container: " + component.getName() + ".");

		}

		if (component.getClass().isInstance(sizeModel)) {
			currentSizePrice = component.getPrice();
			currentSize = (Size) component;
			LOGGER.info("Selected Size: " + component.getName() + ".");
		}

		if (component.getClass().isInstance(flavorModel)) {
			currentFlavorPrice = component.getPrice();
			currentFlavor = (Flavor) component;
			LOGGER.info("Selected Flavor: " + component.getName() + ".");
		}

		if (component.getClass().isInstance(sauceModel)) {
			currentSaucePrice = component.getPrice();
			currentSauce = (Sauce) component;
			LOGGER.info("Selected Sauce: " + component.getName() + ".");
		}

		if (!currentToppings.isEmpty()) {
			currentToppingsPrice = 0.0;
			for (Topping topping : currentToppings) {
				currentToppingsPrice = currentToppingsPrice + topping.getPrice();
			}
		} else {
			currentToppingsPrice = 0.0;
		}

		currentTotalPrice = currentContainerPrice + currentSizePrice + currentFlavorPrice + currentSaucePrice
				+ currentToppingsPrice;
		return component;
	}

	/**
	 * Check user selection
	 * 
	 * @return boolean
	 */
	public boolean checkSelection() {

		if(!(iceCreamNameTextField.getText().isBlank())){
			iceCreamName = iceCreamNameTextField.getText();
			if (!(currentContainer == null)) {

				if (!(currentSize == null)) {

					if (!(currentFlavor == null)) {

						if (!(currentSauce == null)) {
							return true;												
						}
					}
				}
			}
		} else {
			iceCreamNameTextField.setStyle("-fx-border-color: red");
			LOGGER.warn("No ice cream name entered.");
		}
		LOGGER.warn("Some empty fields.");
		return false;
	}

	/**
	 * Initialize the Create Window.
	 */
	@Override
	public void initialize(URL location, ResourceBundle recources) {

		assert berriesToppingCheckBox != null : "fx:id=\"berriesToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert browniesToppingCheckBox != null : "fx:id=\"browniesToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert caramelSauceRadioButton != null : "fx:id=\"caramelSauceRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert cerealsToppingCheckBox != null : "fx:id=\"cerealsToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert chocolateFlavorRadioButton != null : "fx:id=\"chocolateFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert chocolateSauceRadioButton != null : "fx:id=\"chocolateSauceRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert chocolatechipsToppingCheckBox != null : "fx:id=\"chocolatechipsToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert coconutFlavorRadioButton != null : "fx:id=\"coconutFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert coneContainerRadioButton != null : "fx:id=\"coneContainerRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert container != null : "fx:id=\"container\" was not injected: check your FXML file 'Create.fxml'.";
		assert cookiesToppingCheckBox != null : "fx:id=\"cookiesToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert cupContainerRadioButton != null : "fx:id=\"cupContainerRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert gummybearsToppingCheckBox != null : "fx:id=\"gummybearsToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert largeSizeRadioButton != null : "fx:id=\"largeSizeRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert mangoFlavorRadioButton != null : "fx:id=\"mangoFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert mediumSizeRadioButton != null : "fx:id=\"mediumSizeRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert meringuesToppingCheckBox != null : "fx:id=\"meringuesToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert moccaFlavorRadioButton != null : "fx:id=\"moccaFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert nutellaToppingCheckBox != null : "fx:id=\"nutellaToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert nutsToppingCheckBox != null : "fx:id=\"nutsToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert sauce != null : "fx:id=\"sauce\" was not injected: check your FXML file 'Create.fxml'.";
		assert showTotal != null : "fx:id=\"showTotal\" was not injected: check your FXML file 'Create.fxml'.";
		assert size != null : "fx:id=\"size\" was not injected: check your FXML file 'Create.fxml'.";
		assert smallSizeRadioButton != null : "fx:id=\"smallSizeRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert smartiesToppingCheckBox != null : "fx:id=\"smartiesToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert stracciatellaFlavorRadioButton != null : "fx:id=\"stracciatellaFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert strawberryFlavorRadioButton != null : "fx:id=\"strawberryFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert strawberrySauceRadioButton != null : "fx:id=\"strawberrySauceRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert vanillaFlavorRadioButton != null : "fx:id=\"vanillaFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";
		assert waffleToppingCheckBox != null : "fx:id=\"waffleToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert whippedcreamToppingCheckBox != null : "fx:id=\"whippedcreamToppingCheckBox\" was not injected: check your FXML file 'Create.fxml'.";
		assert yogurtFlavorRadioButton != null : "fx:id=\"yogurtFlavorRadioButton\" was not injected: check your FXML file 'Create.fxml'.";

	}

	/**
	 * Show new Scene for Checkout Window.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void showCheckoutScene(MouseEvent event) throws IOException {

		if (checkSelection()) {

			createIceCream();
			URL url = getClass().getResource(CHECKOUT_FXML);
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.<Parent>load();

			CheckoutController checkoutController = loader.getController();
			checkoutController.setUserCreation(username, iceCream);
			checkoutController.setFields();

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
			LOGGER.info("Show Checkout Window.");

		} else {
			showTotal.setStyle("-fx-text-fill: red");
			showTotal.setText("Empty Fields");
		}

	}
	
	/**
	 * Change IceCreamName TextField
	 * @param event
	 */
	 @FXML
	    void changeIceCreamNameTextField(MouseEvent event) {
		 	iceCreamNameTextField.setStyle("-fx-border-color: default");
	    }

	/**
	 * Get Data from Container RadioButton
	 * 
	 * @param event
	 */
	@FXML
	void getContainerData(ActionEvent event) {

		if (coneContainerRadioButton.getId().equals(((RadioButton) container.getSelectedToggle()).getId())) {
			updateIceCream(containerModel.getCone());

		} else if (cupContainerRadioButton.getId().equals(((RadioButton) container.getSelectedToggle()).getId())) {
			updateIceCream(containerModel.getCup());
		}

		updateShowPrice();

	}

	/**
	 * Get Data from Size RadioButton
	 * 
	 * @param event
	 */
	@FXML
	void getSizeData(ActionEvent event) {

		if (smallSizeRadioButton.getId().equals(((RadioButton) size.getSelectedToggle()).getId())) {
			updateIceCream(sizeModel.getSmall());

		} else if (mediumSizeRadioButton.getId().equals(((RadioButton) size.getSelectedToggle()).getId())) {
			updateIceCream(sizeModel.getMedium());

		} else if (largeSizeRadioButton.getId().equals(((RadioButton) size.getSelectedToggle()).getId())) {
			updateIceCream(sizeModel.getLarge());
		}

		updateShowPrice();
	}

	/**
	 * Get Data from Flavor RadioButton
	 * 
	 * @param event
	 */
	@FXML
	void getFlavorData(ActionEvent event) {

		if (chocolateFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getChocolate());
			
		} else if (vanillaFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getVanilla());
			
		} else if (strawberryFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getStrawberry());

		} else if (stracciatellaFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getStracciatella());

		} else if (moccaFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getMocca());

		} else if (mangoFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getMango());
			
		} else if (coconutFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getCoconut());

		} else if (yogurtFlavorRadioButton.getId().equals(((RadioButton) flavor.getSelectedToggle()).getId())) {
			updateIceCream(flavorModel.getYogurt());

		}

		updateShowPrice();
	}

	/**
	 * Get Data from Sauce RadioButton
	 * 
	 * @param event
	 */
	@FXML
	void getSauceData(ActionEvent event) {

		if (chocolateSauceRadioButton.getId().equals(((RadioButton) sauce.getSelectedToggle()).getId())) {
			updateIceCream(sauceModel.getChocolate());

		} else if (caramelSauceRadioButton.getId().equals(((RadioButton) sauce.getSelectedToggle()).getId())) {
			updateIceCream(sauceModel.getCaramel());

		} else if (strawberrySauceRadioButton.getId().equals(((RadioButton) sauce.getSelectedToggle()).getId())) {
			updateIceCream(sauceModel.getStrawberry());

		}

		updateShowPrice();
	}

	/**
	 * Get Data from Topping RadioButton
	 * 
	 * @param event
	 */
	@FXML
	void getToppingData(ActionEvent event) {

		if (whippedcreamToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getWhippedCream());
		} else {
			removeTopping(toppingsModel.getWhippedCream());
		}

		if (chocolatechipsToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getChocolateChips());
		} else {
			removeTopping(toppingsModel.getChocolateChips());
		}

		if (browniesToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getBrownies());
		} else {
			removeTopping(toppingsModel.getBrownies());
		}

		if (cookiesToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getCookies());
		} else {
			removeTopping(toppingsModel.getCookies());
		}

		if (waffleToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getWaffle());
		} else {
			removeTopping(toppingsModel.getWaffle());
		}

		if (smartiesToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getSmarties());
		} else {
			removeTopping(toppingsModel.getSmarties());
		}

		if (nutsToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getNuts());
		} else {
			removeTopping(toppingsModel.getNuts());
		}

		if (gummybearsToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getGummyBears());
		} else {
			removeTopping(toppingsModel.getGummyBears());
		}

		if (nutellaToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getNutella());
		} else {
			removeTopping(toppingsModel.getNutella());
		}

		if (cerealsToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getCereals());
		} else {
			removeTopping(toppingsModel.getCereals());
		}

		if (berriesToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getBerries());
		} else {
			removeTopping(toppingsModel.getBerries());
		}

		if (meringuesToppingCheckBox.isSelected()) {
			addTopping(toppingsModel.getMeringues());
		} else {
			removeTopping(toppingsModel.getMeringues());
		}

		updateIceCream(toppingsModel);
		updateShowPrice();

	}

}
