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
     
     ArrayList<petADT> pets = Parser.parse("data/Animal_Tag_DATA_2015_8.csv");
     System.out.println(pets.size());
     
     String[] petsBreeds = new String[pets.size()];
     for (int i = 0; i < pets.size(); i++){
    	 petsBreeds[i] = pets.get(i).getBreedGroup();
     }
     //System.out.println(Arrays.toString(petsBreeds));
     heapSort.sortHeap(petsBreeds);
     PetHeapSort.sortHeap(pets);
     
     BufferedWriter outputWriter = null;
     outputWriter = new BufferedWriter(new FileWriter("data/indices.txt"));
     for (String s : petsBreeds) {
    	 outputWriter.write(s);
    	 outputWriter.newLine();
    	 //System.out.println(s);
     }
     outputWriter.flush();  
     outputWriter.close();
     
     String[] petResults = questions.getList();

	 ArrayList<Integer> petIndex = new ArrayList<Integer>();
	 String[] temp = petsBreeds;
    // int[] petIndex;
     //int count = 0;
//	 System.out.println("bdaskjdhkjas");
//	 System.out.println(petsBreeds[103457]);

	 
	 for (String s: petResults) {
		 int lowBound = BinarySearch.lower_bound(temp, s);
		 int highBound = BinarySearch.upper_bound(temp, s);
		 
		 for (int i = lowBound; i<highBound; i++) {
			 petIndex.add(i);
			 //System.out.println(x);
		 }
	 }
	 
	 
	 
	 
	 
//     for (int i = 0; i < petResults.length; i++){
//    	 //temp = petsBreeds;
//    	 while(BinarySearch.binarySearch(temp, petResults[i]) != -1){
//    		 
//			 int index = Arrays.binarySearch (temp, petResults[i]);
//			 int first = index;
//			 int last = index;
//			 if (index >= 0) {
//			     while (first > 0 && temp[first-1] == petResults[i])
//			         first--;
//			     while (last < temp.length - 1 && temp[last+1] == petResults[i])
//			    	 last++;
//			 }
//    		 
//    		  petIndex.add(BinarySearch.binarySearch(temp, petResults[i]));
////    		  //petIndex[count] = BinarySearch.binarySearch(petsBreeds, petResults[i]);
////	       	  //count++;
//	       	  temp[BinarySearch.binarySearch(temp, petResults[i])] = "found";
//    	 }
//     }
     
//     System.out.println(Arrays.toString(petIndex.toArray()));
     
    for (int k =0; k< petIndex.size(); k++) {
    	int ind = petIndex.get(k);
    	//System.out.println(ind);
    	petADT urmom = pets.get(ind);
    	System.out.println("Species: " + urmom.getSpecies() + " Breed: " + urmom.getBreedGroup() + " Age: " + urmom.getYearsAge());
    	
    }
    
//    for(int i =0; i< petIndex.size(); i++){
//    	System.out.println(petIndex.get(i));
//    }

//    System.out.println(petsBreeds[103457]);
    }
}
