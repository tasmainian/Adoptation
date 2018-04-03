package cas.xb3.adoptation.framework;

import java.util.ArrayList;

public class finalPetADTHeapSort {
	
	public static void sortHeap (ArrayList<finalPetADT> x) {
		int n = x.size();
		for (int i = n / 2; i >= 1; i--)
			sink(x, i, n);
		
		while (n > 1){
			swap(x, 1, n--);
			sink(x, 1, n);
		}
	}
		
	/**
	 * Helper function to ensure object maintains heap properties
	 * @param x - input array
	 * @param i - index
	 * @param n - size of input array
	 */
	private static void sink(ArrayList<finalPetADT> x, int i, int n) {
	    	
		while (2 * i <= n) {
			int j = 2 * i;
	            
	        if (j < n && (x.get(j-1).getCount() < (x.get(j).getCount()) )) 
	        	j++;
	            
	        if (x.get(i-1).getCount() >= x.get(j-1).getCount()) 
	           	break;
	            
	        swap(x, i, j);
	        i = j;
	    }
	}
	    
	/**
	 * Helper function for swapping 2 elements
	 * @param obj - array of objects
	 * @param index1 - index of first element
	 * @param index2 - index of second element
	 */	
	private static void swap(ArrayList<finalPetADT> x, int index1, int index2) {
		
		finalPetADT temp = x.get(index1-1);
		
		x.set(index1-1, x.get(index2-1));
		
		x.set(index2-1, temp);
		
//		petADT temp = pets.get(index1-1);
//		//Object temp = obj[index1-1];
//			
//		pets.set(index1-1, pets.get(index2-1));
//		
//		//obj[index1-1] = obj[index2-1];
//		
//		pets.set(index2-1, temp);
//		
//		//obj[index2-1] = temp;
//			
//		Object temp = obj[index1-1];
//		obj[index1-1] = obj[index2-1];
//		obj[index2-1] = temp;
	}
	/*
	public static void main(String[] args) {

        String array[] ={"f","a","c","b","g","d","e"};
        sortHeap(array);

        for (int i=0; i<array.length; i++) {
        	System.out.println(array[i]);
        }
	}*/
	

}
