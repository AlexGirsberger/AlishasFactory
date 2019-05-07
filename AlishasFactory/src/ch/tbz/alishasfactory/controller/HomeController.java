package ch.tbz.alishasfactory.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.tbz.alishasfactory.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 * @since 2019-04-12
 *
 */

public class HomeController implements Initializable {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	static private String CREATE_FXML = "../view/Create.fxml";
	private String username;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button createButton;

    @FXML
    private TextField userNameTextField;

	/**
	 * Get username input.
	 * 
	 * @return boolean
	 */
	public boolean getUserName() {
	
		if (userNameTextField.getText().isBlank()) {
			LOGGER.warn("No username entered.");
			return false;
			
		} else {
			username = userNameTextField.getText();
			LOGGER.info("Set username.");
			return true;
		}
	}
 
	/**
	 * Shows new Scene for Create Window.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void showCreateScene(MouseEvent event) throws IOException {

		if(getUserName()) {
		URL url = getClass().getResource(CREATE_FXML);
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.<Parent>load();

		// Calls method in CreateController to set ice cream name.
		CreateController createController = loader.getController();
		createController.setUserName(username);

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
		LOGGER.info("Show Create Window.");
		
		} 
	}

	
	/**
	 * Initializes the Home Window.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'Home.fxml'.";
		
	}
}
