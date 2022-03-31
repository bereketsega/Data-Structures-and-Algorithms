package algorithms.sorting;

/**
 * Implementation of Insertion Sort Algorithm
 * 
 * @author Bereket Sega
 */
public class InsertionSort {

    /**
     * sorts an array by bringing an element to its position
     * T/S : O(n^2)/O(1)
     * 
     * @param arr the array to be sorted
     */
    public static void insertionSort(int[] arr) {
        
        for (int i = 1; i < arr.length; i++) {
            
            int key = arr[i]; // the current element to be inserted 
            int j = i - 1; // index of left of key
            
            // insert until j index out of bound or left of key is greater than key
            while ( j > -1 && arr[j] > key) {
                //shift right since j'th element is > key
                arr[j+1] = arr[j];
                j--; // move left to compare to key
            }
            arr[j+1] = key; // final position of key
        }

    }

    // Test
    public static void main(String[] args) {
        
        int[] arr = {10, 9, 23, 89, 4, 11};
        
        insertionSort(arr);
        
        // print sorted array
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

    }
}
