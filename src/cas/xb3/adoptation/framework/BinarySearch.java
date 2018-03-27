package cas.xb3.adoptation.framework;
import java.util.Arrays;
import cas.xb3.adoptation.framework.heapSort;


public class BinarySearch {
	public static int binarySearch(String[] list, String key) {
	    int low = 0;
	    int high = list.length - 1;

	    while (high >= low) {
	      int mid = (low + high) / 2;
	      
	      if (list[mid].compareTo(key) < 0)
	        low = mid + 1;
	      else if (list[mid].compareTo(key) > 0)
	        high = mid -1;
	      else
	        return mid;
	    }

	    return -1; 
	  }
/*
	public static void main(String[] args) {

        String array[] ={"b","a","c","d","e","f","g"};
        String search = "a";

        heapSort.sortHeap(array);

        int index = binarySearch(array,search);

        System.out.println(index != -1 ? array[index]+ " - Index is "+index : "Not found");
    }*/
    
}
