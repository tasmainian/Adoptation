package cas.xb3.adoptation.framework;
import java.util.Arrays;
import cas.xb3.adoptation.framework.heapSort;


public class BinarySearch {
	public static int binarySearch(String[] list, String key) {
	    int low = 0;
	    int high = list.length - 1;
	    int mid;

	    while (high >= low) {
	      mid = (low + high) / 2;
	      
	      if (list[mid].compareTo(key) < 0)
	        low = mid + 1;
	      else if (list[mid].compareTo(key) > 0)
	        high = mid -1;
	      else
	        return mid;
	    }

	    return -1; 
	  }
	
	 public static int lower_bound(String[] arr, String key) {
	        int len = arr.length;
	        int lo = 0;
	        int hi = len-1;
	        int mid = (lo + hi)/2;
	        while (true) {
	            int cmp = arr[mid].compareTo(key);
	            if (cmp == 0 || cmp > 0) {
	                hi = mid-1;
	                if (hi < lo)
	                    return mid;
	            } else {
	                lo = mid+1;
	                if (hi < lo)
	                    return mid<len-1?mid+1:-1;
	            }
	            mid = (lo + hi)/2;
	        }
	    }

	    public static int upper_bound(String[] arr, String key) {
	        int len = arr.length;
	        int lo = 0;
	        int hi = len-1;
	        int mid = (lo + hi)/2;
	        while (true) {
	            int cmp = arr[mid].compareTo(key);
	            if (cmp == 0 || cmp < 0) {
	                lo = mid+1;
	                if (hi < lo)
	                    return mid<len-1?mid+1:-1;
	            } else {
	                hi = mid-1;
	                if (hi < lo)
	                    return mid;
	            }
	            mid = (lo + hi)/2;
	        }
	    }

	public static void main(String[] args) {

        String array[] ={"b","a","c","d","e","f","g", "c", "c" , "c", "c", "c"};
        String search = "c";

        heapSort.sortHeap(array);

        int index = binarySearch(array,search);
        int lowerBound = lower_bound(array, search);
        int upperBound = upper_bound(array, search); 

        //System.out.println(index != -1 ? array[index]+ " - Index is "+index : "Not found");
        System.out.println("reg binary: " + index + " lower: " + lowerBound + " upper: " + upperBound);
        
	}
//    
}
