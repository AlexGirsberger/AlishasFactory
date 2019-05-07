package ch.tbz.alishasfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class of the Alisha's Factory application. It is responsible
 * to call method to access the database and to load the Home User Interface's
 * XML File.
 * 
 * @author Alexandra Girsberger, Thamisha Thanabalasingam
 * @since 2019-04-12
 *
 */

public class Main extends Application {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	@Override
	public void start(Stage stage) throws Exception {
			
			Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			LOGGER.info("Show Home Window.");
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
