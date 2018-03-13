package cas.xb3.adoptation.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The <i>Adoptation</i> client's MainClass.
 * 
 * <p>
 * This class contains the main method and handles all essential UI/initial program setup.
 * </p>
 * @author Owen McNeil, ...
 * @version 1.0
 */
public class Adoptation extends Application {
	
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		primaryStage.setTitle("Adoptation");
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
	}

}
