package algorithms.sorting;

/**
 * Implementation of Quick Sort Algorithm
 * 
 * @author Bereket Sega
 */
public class QuickSort {
    
    /**
     * partitions the array into two parts
     * left side to be less than pivot(first element)
     * and right side to be greater than the pivot
     * 
     * @param arr the array to be partitioned
     * @param low the left most index to be partitioned
     * @param high the right most index to be partitioned
     * @return the new pivot index
     */
    private static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[low];
        int left = low;
        int right = high;

        while (left < right) {
            // find an element greater than pivot on left half
            while (left <= high && arr[left] <= pivot) {
                left++;
            }
            // find an element less than pivot on right half
            while (right >= low && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                // swap 
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            } 
        }
        // reassign pivot
        arr[low] = arr[right];
        arr[right] = pivot;

        return right;
    }

    /**
     * sorts an array by bringing numbers smaller than the pivot to left
     * and greater than the pivot to the right side of the array
     * T/S:O(n^2)/O(logn)
     * 
     * @param arr the array to be sorted
     * @param low the left most index of the array
     * @param high the right most index of the array
     */
    public static void quickSort(int[] arr, int low, int high){
        
        if (low < high) {
            int pivot = partition(arr, low, high);

            // sort left half
            quickSort(arr, low, pivot);
            // sort right half
            quickSort(arr, pivot+1, high);
        }

    }

    // Test
    public static void main(String[] args) {
        
        int[] arr = {4, 2, 9, 3, 11, 23, 8, 17};
        
        quickSort(arr, 0, arr.length-1); 
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }
    
}
