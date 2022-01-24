package algorithms.sorting;

/**
 * Implementation of Bubble Sort Algorithm
 * 
 * @author Bereket Sega
 */
public class BubbleSort {

    /**
     * bubble sort method to sort an array
     * T/S:O(n^2)/O(1)
     * 
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        
        int len = arr.length;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                if (arr[j] > arr[j+1]) {
                    // temp store
                    int temp = arr[j];
                    // swap
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // Print sorted array
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
        
    }

     // Test
    public static void main(String[] args) {
    
        int[] arr = {437,46,4,3,445,43,1};

        // Print unsorted array
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
        bubbleSort(arr);

    }

}
