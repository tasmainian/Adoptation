package cas.xb3.adoptation.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller implements Initializable {
	
	public ToggleGroup searchGroup;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Loading data...");
		
		RadioButton selectedSearch = (RadioButton)searchGroup.getSelectedToggle();
		System.out.println(selectedSearch.getText());
	}
	
	/**
	 * Wrapper method for graphing alg./personality test
	 */
	public void onMatchTestClick() {
		
	}
	
	

}
