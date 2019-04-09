package ch.tbz.alishasfactory.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Home Controller for the home.fxml file. Calls the Create Controller and it's
 * FXML file.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-05
 *
 */

public class HomeController {

	static private String CREATE_FXML = "../view/Create.fxml";

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button createButton;

	@FXML
	private TextField iceCreamNameTextField;

	/**
	 * Get Ice Cream name input from user input.
	 * 
	 * @return String
	 */
	public String getIceCreamName() {
		String iceCreamName = "";

		if (iceCreamNameTextField.getText().isBlank()) {
			iceCreamName = "User's Ice Cream";
		} else {
			iceCreamName = iceCreamNameTextField.getText();
		}
		return iceCreamName;
	}
 
	/**
	 * Shows new Scene for Create Window.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void showCreateScene(MouseEvent event) throws IOException {

		URL url = getClass().getResource(CREATE_FXML);
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.<Parent>load();

		// Calls method in CreateController to set ice cream name.
		CreateController createController = loader.getController();
		createController.setIceCreamName(getIceCreamName());

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();

	}

	/**
	 * Initializes the Home Window.
	 */
	@FXML
	void initialize() {
		assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'Home.fxml'.";
	}

}
