/**
 * @author Tasmiha Hassan
 * @date March 15, 2018
 */
package cas.xb3.adoptation.framework;

import java.io.*;  
import java.util.*;

public class MainQ {
 public static final String QUESTIONAIRE = "data/question.txt";
 private static Scanner c = new Scanner(System.in);

 public static void main(String[] args) throws IOException {
     System.out.println("Let's find you the perfect pet!");
     System.out.println();
     
     
     //prompt to begin
	 System.out.print("Would you like to begin (y/n)? ");
	 String response = c.nextLine().trim().toLowerCase();
	 while (!response.equals("y") && !response.equals("n")) {
			System.out.println("Please answer y or n.");
	        System.out.print("Would you like to begin (y/n)? ");
	        response = c.nextLine().trim().toLowerCase();
	 }
	 
	 //creating a Tree object
     Tree questions = new Tree();
     
     //loading the questions into the tree object
     if (response.equals("y"))
         questions.read(new Scanner(new File(QUESTIONAIRE)));
     else if (response.equals("n"))
    	 System.exit(0);
     
     System.out.println();

     //going down the tree with the answers from the user
     while (questions.ask().left == null && questions.ask().right == null){
         questions.ask();
         System.out.println();
     }
     System.out.println();
     System.out.println(Arrays.toString(questions.getList()));
     
     
     //****************************ALGORITHMS IMPLEMENTATION***********************
     ArrayList<petADT> pets = Parser.parse("data/Animal_Tag_DATA_2015_8.csv");
     //System.out.println(pets.size());
     
     //Loads all the pet breeds onto a string array
     String[] petsBreeds = new String[pets.size()];
     String[] petsPrimaryBreed = new String[pets.size()];

     for (int i = 0; i < pets.size(); i++){
    	 petsBreeds[i] = pets.get(i).getBreedGroup();
    	 petsPrimaryBreed[i] = pets.get(i).getPrimaryBreed();

     }
     //System.out.println(Arrays.toString(petsBreeds));
     
     //SORTS THE PET BREEDs ALPHBATICALLY
     heapSort.sortHeap(petsBreeds);
     
     //Sorts the ADT in the same order as the pet breeds
     PetHeapSort.sortHeap(pets);
     
     
     //Testing the outputs to see if it works
     /*
     BufferedWriter outputWriter = null;
     outputWriter = new BufferedWriter(new FileWriter("data/indices.txt"));
     for (String s : petsBreeds) {
    	 outputWriter.write(s);
    	 outputWriter.newLine();
    	 //System.out.println(s);
     }
     outputWriter.flush();  
     outputWriter.close();*/
     
     //Obtains the list of results from the questionnaire
     String[] petResults = questions.getList();

     //idk
     ArrayList<Integer> petIndex = new ArrayList<Integer>();
	 String[] temp = petsBreeds;
    // int[] petIndex;
     //int count = 0;
	 
	 
	 //Finds the first to last repetitive breed in the list
	 for (String s: petResults) {
		 int lowBound = BinarySearch.lower_bound(temp, s);
		 int highBound = BinarySearch.upper_bound(temp, s);
		 
		 //Finds all the index of all the breeds
		 for (int i = lowBound; i<highBound; i++) {
			 petIndex.add(i);
		 }
	 }
     
    for (int k =0; k< petIndex.size(); k++) {
    	int ind = petIndex.get(k);
    	//System.out.println(ind);
    	petADT petOptions = pets.get(ind);
    	System.out.println("Species: " + petOptions.getSpecies() + " Breed: " + petOptions.getBreedGroup() + " Age: " + petOptions.getYearsAge());
    	
    }
    
    }
}
