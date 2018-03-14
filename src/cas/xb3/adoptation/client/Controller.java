package cas.xb3.adoptation.client;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import cas.xb3.adoptation.framework.Parser;
import cas.xb3.adoptation.framework.petADT;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
	
	private ArrayList<petADT> originalPetData;
	public ObservableList<petADT> oPetData;
	
	// UI elements
	@FXML private ToggleGroup searchGroup;
	@FXML private TableView<petADT> petView; 
	@FXML private TableColumn<petADT, String> breedCol;
	@FXML private Button btnSort;
	
	@FXML
	private void onBtnSortClick() {
		oPetData.clear();
		System.out.println("kapa");
	}
	
	@FXML
	private void initialize() {
		System.out.println("Loading initial data...");
		
		//RadioButton selectedSearch = (RadioButton)searchGroup.getSelectedToggle();
		//System.out.println(selectedSearch.getText());
		
		try {
			originalPetData = Parser.parse("data/Animal_Tag_DATA_2015_8.csv");
			oPetData = FXCollections.observableArrayList(originalPetData);
		} catch (IOException e) {
			try {
				// throw error saying data couldn't be loaded
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		breedCol.setCellValueFactory(new PropertyValueFactory<petADT, String>("primaryBreed"));
		//petView.setSortPolicy(FXCollections.sort(oPetData)); <= change to our own sorting methods
		petView.setItems(oPetData);
	}
	

}
