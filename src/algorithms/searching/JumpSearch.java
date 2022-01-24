package algorithms.searching;

/**
 * Implementation of Jump Search Algorithm
 * 
 * @author Bereket Sega
 */
public class JumpSearch {
    
    /**
     * searches for an element in an array
     * T/S : O(sqrt(n))/O(1)
     * 
     * @param arr the array we're searching an element in 
     * @param key the element we're searching for 
     * @return the index of key or -1 if not found
     */
    public static int jumpSearch(int[] arr, int key) {
        // steps to skip checking
        int step = (int) Math.sqrt(arr.length);
        // index of each step
        int index = step;
        // until index is out of bound or element at index is less than key
        while (index < arr.length && arr[index] < key) {
            index+=step; // increment index by step
        }
        // lineaer search for key 
        for (int i = index-step; i <= Math.min(index, arr.length-1); i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

     // Test
    public static void main(String[] args) {

        int[] arr = {2,4,6,7,9,12,44};
        System.out.println(jumpSearch(arr, 12));
    }

}
