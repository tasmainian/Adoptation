/**
 * @author Tasmiha Hassan - modified by Owen McNeil
 * @date March 15, 2018
 */
package cas.xb3.adoptation.framework;

import java.io.*;
import java.util.*;

public class TestParser {

		private static ArrayList<petADT> pets;
		public static final String QUESTIONAIRE = "data/question.txt";
		
		public static ArrayList<petADT> parseResults(Tree questions) {
			try {
				pets = Parser.parse("data/Animal_Tag_DATA_2015_8.csv");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < pets.size(); i++){
				if(!pets.get(i).getStatus().equals("ACTIVE")){
					pets.remove(i);
				}
			}
			if(questions.getType().equals("A") || questions.getType().equals("B") || questions.getType().equals("C")){
				for(int i = 0; i < pets.size(); i++){
					if(!pets.get(i).getSpecies().equals("DOG")){
						pets.remove(i);
					}
				}
			}
			
			else{
				for(int i = 0; i < pets.size(); i++){
					if(!pets.get(i).getSpecies().equals("CAT")){
						pets.remove(i);
					}
				}
			}
			// Loads all the pet breeds onto a string array
			String[] petsBreeds = new String[pets.size()];
			String[] petsPrimaryBreed = new String[pets.size()];

			for (int i = 0; i < pets.size(); i++) {
				petsBreeds[i] = pets.get(i).getBreedGroup();
				petsPrimaryBreed[i] = pets.get(i).getPrimaryBreed();
			}
			// System.out.println(Arrays.toString(petsBreeds));

			// SORTS THE PET BREEDs ALPHBATICALLY
			heapSort.sortHeap(petsBreeds);
			heapSort.sortHeap(petsPrimaryBreed);

			// Sorts the ADT in the same order as the pet breeds
			PetHeapSort.sortHeap(pets);

			// Obtains the list of results from the questionnaire
			String[] petResults = questions.getList();

			// idk
			ArrayList<Integer> petIndex = new ArrayList<Integer>();
			String[] temp = petsBreeds;

			// Finds the first to last repetitive breed in the list
			ArrayList<String> listPrimary = new ArrayList<String>();
			for (String s : petResults) {
				int lowBound = BinarySearch.lower_bound(temp, s);
				int highBound = BinarySearch.upper_bound(temp, s);

				// Finds all the index of all the breeds
				for (int i = lowBound; i < highBound; i++) {
					if (!listPrimary.contains(pets.get(i).getPrimaryBreed())) {
						listPrimary.add(pets.get(i).getPrimaryBreed());
					}
					petIndex.add(i);
				}
			}
			ArrayList<petADT> primBreed = new ArrayList<petADT>();
			for (int k = 0; k < petIndex.size(); k++) {
				int ind = petIndex.get(k);
				primBreed.add(pets.get(ind));
				petADT petOptions = pets.get(ind);
			}

			ArrayList<petADT> petsNew = pets;
			PetHeapSortPrimary.sortHeap(petsNew);		
			PetHeapSortPrimary.sortHeap(primBreed);
			
			String[] finalBreeds = new String[primBreed.size()];
			for (int i = 0; i<finalBreeds.length; i++) {
				finalBreeds[i]=primBreed.get(i).getPrimaryBreed();
			}
			List asList = Arrays.asList(finalBreeds);
			
			ArrayList<finalPetADT> tas= new ArrayList<finalPetADT>();
			
			Set<String> mySet = new HashSet<String>(asList);
			for(String s: mySet){
				finalPetADT finalpetshit = new finalPetADT(s,Collections.frequency(asList,s));
				tas.add(finalpetshit);
			}
			
			finalPetADTHeapSort.sortHeap(tas);
			Collections.reverse(tas);
			int size;
			if(tas.size()< 4){
				size = tas.size();
			}
			else {
				size = 3;
			}
			String[] selectedBreeds = new String[size];
			for(int i = 0; i < size; i++) {
				System.out.println("Breed: " + tas.get(i).getPrimBreed() + " Count: " + tas.get(i).getCount());
				selectedBreeds[i] = tas.get(i).getPrimBreed();
			}
			
			ArrayList<petADT> goodPets = new ArrayList<petADT>();
			
			for (int i = 0; i < pets.size(); i ++) {
				boolean goodPet = false;
				for (int j = 0; j < size; j++) {
					if (pets.get(i).getPrimaryBreed().equalsIgnoreCase(selectedBreeds[j])) {
						goodPet = true;
						
					}
				}
				
				if (goodPet == true) {
					goodPets.add(pets.get(i));
				}
				
			}
			
			return goodPets;
			
		}
		
		}
		
		

