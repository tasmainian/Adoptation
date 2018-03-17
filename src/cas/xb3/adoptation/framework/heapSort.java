package cas.xb3.adoptation.framework;

public class heapSort {
	
	/**
	 * Heap sort using Comparable
	 * @param x - input array
	 * @param n - size of input array
	 */	
	public static void sortHeap (Comparable[] x, int n) {
			
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
	private static void sink(Comparable[] x, int i, int n) {
	    	
		while (2 * i <= n) {
			int j = 2 * i;
	            
	        if (j < n && (x[j-1].compareTo(x[j]) < 0)) 
	        	j++;
	            
	        if (x[i-1].compareTo(x[j-1]) >= 0) 
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
	private static void swap(Object[] obj, int index1, int index2) {
			
		Object temp = obj[index1-1];
		obj[index1-1] = obj[index2-1];
		obj[index2-1] = temp;
	}
	
	
}
