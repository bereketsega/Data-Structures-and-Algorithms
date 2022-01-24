package algorithms.searching;

/**
 * Implementation of Linear Search
 * 
 * @author Bereket Sega
 */
public class LinearSearch {
    
    /**
     * searches an element by comparing each element in the array
     * T/S : O(n)/O(1)
     * 
     * @param arr the array we're searching the element in
     * @param key the element to be searched
     * @return the index of key or -1 if not found
     */
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Test
    public static void main(String[] args) {
        
        int[] arr = {2,4,6,7,9,12,44};
        System.out.println(linearSearch(arr, 9));

    }
    
}
