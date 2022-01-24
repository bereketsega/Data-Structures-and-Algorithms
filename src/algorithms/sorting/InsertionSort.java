package algorithms.sorting;

/**
 * Implementation of Insertion Sort Algorithm
 * 
 * @author Bereket Sega
 */
public class InsertionSort {

    /**
     * sorts an array by bringing the min element to its position
     * T/S : O(n^2)/O(1)
     * 
     * @param arr the array to be sorted
     */
    public static void insertionSort(int[] arr) {
        
        for (int i = 0; i < arr.length-1; i++) {
            
            int idx = i+1;
            int min = arr[idx];
            
            for (int j = i; j >= 0; j--) {
                // when next element is greater
                if (arr[j] <= min) {
                    continue;
                }
                // when next element is lesser
                if (min < arr[j]) {
                    // shift min element left
                    int temp = arr[j];
                    arr[j] = arr[idx];
                    arr[idx] = temp;
                    idx--;
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
