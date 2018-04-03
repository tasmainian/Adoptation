package cas.xb3.adoptation.framework;

import java.util.ArrayList;

import cas.xb3.adoptation.framework.petADT;

public class PetHeapSortPrimary {
	
	
	public static void sortHeap (ArrayList<petADT> pets) {
		int n = pets.size();
		for (int i = n / 2; i >= 1; i--)
			sink(pets, i, n);
		
		while (n > 1){
			swap(pets, 1, n--);
			sink(pets, 1, n);
		}
	}
	
	private static void sink(ArrayList<petADT> pets, int i, int n) {
    	
		while (2 * i <= n) {
			int j = 2 * i;
	            
	        if (j < n && (pets.get(j-1).getPrimaryBreed().compareTo(pets.get(j).getPrimaryBreed()) < 0)) 
	        	j++;
	            
	        if (pets.get(i-1).getPrimaryBreed().compareTo(pets.get(j-1).getPrimaryBreed()) >= 0) 
	           	break;
	            
	        swap(pets, i, j);
	        i = j;
	    }
	}
	
	private static void swap(ArrayList<petADT> pets, int index1, int index2) {
		petADT temp = pets.get(index1-1);
		//Object temp = obj[index1-1];
			
		pets.set(index1-1, pets.get(index2-1));
		
		//obj[index1-1] = obj[index2-1];
		
		pets.set(index2-1, temp);
		
		//obj[index2-1] = temp;
	}
	
	

}
