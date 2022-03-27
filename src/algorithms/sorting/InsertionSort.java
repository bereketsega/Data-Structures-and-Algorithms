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
            
            int min = arr[i];
            
            for (int j = i; j >= 0; j--) {

                // when next element is lesser
                if (min < arr[j]) {
                    // shift min element left
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i--;
                }
                
            }
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
