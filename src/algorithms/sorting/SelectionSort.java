package algorithms.sorting;

/**
 * Implementation of Selection Sort
 * 
 * @author Bereket Sega
 */
public class SelectionSort {

    /**
     * sorts an array in non-decreasing order
     * T/S : O(n^2)/O(1)
     * 
     * @param arr the array to be sorted
     */
    public static void selectionSort(int[] arr) {
        // swap an element by the smallest 
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i; j < len; j++) {
                // find min and its index
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = min;
            arr[idx] = temp;
        }
    }

    // Test
    public static void main(String[] args) {
        
        int[] arr = {34, 4, 46, 2, 66, 7};

        selectionSort(arr);

        // print the sorted array
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

}
