package cas.xb3.adoptation.framework;

public class Heap {
	
	/**
	 * @author Tasmiha Hassan, hassat3, 400083305
	 * @version Eclipse Luna 
	 */
		/**
		 * heap sort using Comparable
		 * @param x - the input array containing jobs that need to be sorted.
		 * @param n - the size of the input array
		 * @return the sorted array
		 */
		//PAGE 324 of Algorithms textbook
		public static void sortHeap ( Comparable[] x, int n ) {
			for (int i = n/2; i >= 1; i--){
				sink (x, i, n);
			}
			
			while (n>1){
				exch(x, 1, n--); 
				sink(x, 1, n);
			}
		}
		
		//PAGE 316 of Algorithms textbook
	    private static void sink(Comparable[] a, int k, int n) {
	        while (2*k <= n) {
	            int j = 2*k;
	            if (j < n && less(a, j, j+1)) 
	            	j++;
	            if (!less(a, k, j)) 
	            	break;
	            exch(a, k, j);
	            k = j;
	        }
	    }


	    //Reference from Algorithms, 4th Edition Online Code Examples
		/**
		 * @param a - the input array containing jobs that need to be sorted.
		 * @param n - an index on the array
		 * @param i - another index on the array to compare to
		 * @return a boolean value
		 */
	    private static boolean less(Comparable[] a, int i, int j) {
	        return a[i-1].compareTo(a[j-1]) < 0; //indices off by one to support one-based indexing
	    }

		//PAGE 251 OF Algorithms textbook
		/**
		 * @param a - the input array containing jobs that need to be sorted.
		 * @param n - an index on the array
		 * @param i - another index on the array to compare to
		 * @return a new array with swapped values
		 */
	    private static void exch(Comparable[] a, int i, int j) {
	        Comparable swap = a[i-1]; //holds the value of a[i-1]
	        a[i-1] = a[j-1]; //transfers the value of a[j-1] to a[i-1]
	        a[j-1] = swap; //gets the new held value
	    }


}

