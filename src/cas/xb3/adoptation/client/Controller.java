package cas.xb3.adoptation.client;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
	@FXML private TableColumn<petADT, String> genderCol;
	@FXML private TableColumn<petADT, String> ageCol;
	@FXML private TableColumn<petADT, String> colorCol;
	@FXML private Button btnSort;
	

	@FXML
	private void initialize() {
		System.out.println("Loading initial data...");
		
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
		genderCol.setCellValueFactory(new PropertyValueFactory<petADT, String>("sex"));
		// TODO: some pets have age of 0 (less than 0 years, some don't have age setup at all)
		ageCol.setCellValueFactory(new PropertyValueFactory<petADT, String>("yearsAge"));
		colorCol.setCellValueFactory(new PropertyValueFactory<petADT, String>("primaryColour"));
		
		
		petView.setItems(oPetData);
		
	}
	
	@FXML
	public void onBtnSortClick() {

		RadioButton selectedSearch = (RadioButton)searchGroup.getSelectedToggle();
		String sortTeq = selectedSearch.getText();
		
		switch(sortTeq) {
		case "Breed":
			FXCollections.sort(oPetData, new PetBreedComparator());
			break;
		case "Gender":
			FXCollections.sort(oPetData, new PetGenderComparator());
			break;
		case "Age":
			FXCollections.sort(oPetData, new PetAgeComparator());
			break;
		case "Color":
			FXCollections.sort(oPetData, new PetColorComparator());
			break;
		default:
			System.out.println("Error occured @ onBtnSortClick parsing!");
			break;
		}
			
	}
	
	/**
	 * Clears the data array and sets in to the default, full dataset
	 */
	@FXML
	public void onResetClick() {
		oPetData.clear();
		oPetData = FXCollections.observableArrayList(originalPetData);
		petView.setItems(oPetData);
	}
	
	static class PetBreedComparator implements Comparator<petADT> {

		@Override
		public int compare(petADT pet1, petADT pet2) {
			return pet1.getPrimaryBreed().compareTo(pet2.getPrimaryBreed());
		}
		
	}
	
	static class PetGenderComparator implements Comparator<petADT> {

		@Override
		public int compare(petADT pet1, petADT pet2) {
			return pet1.getSex().compareTo(pet2.getSex());
		}
		
	}
	
	static class PetAgeComparator implements Comparator<petADT> {

		@Override
		public int compare(petADT pet1, petADT pet2) {
			return pet1.getYearsAge().compareTo(pet2.getYearsAge());
		}
		
	}
	
	static class PetColorComparator implements Comparator<petADT> {

		@Override
		public int compare(petADT pet1, petADT pet2) {
			return pet1.getPrimaryColour().compareTo(pet2.getPrimaryColour());
		}
		
	}
	

}
