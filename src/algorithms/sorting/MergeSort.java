package algorithms.sorting;

/**
 * Implementation of Merge Sort Algorithm
 * 
 * @author Bereket Sega
 */
public class MergeSort {
    
    /**
     * divides the array into halves until 2 elements left
     * and sort and merge each sub array.
     * 
     * @param A the array to be sorted.
     * @param start the left most index of the array.
     * @param end the right most index of the array.
     */
    public static void mergeSort(int[] A, int start, int end) {

        if (start < end) {
            int mid = (int) Math.floor((start+end)/2);
            // left sub array
            mergeSort(A, start, mid);
            // right sub array
            mergeSort(A, mid+1, end);

            merge(A, start, mid, end);
        }

    }

    /**
     * sorts sub arrays from low <-> mid and mid <-> high and 
     * merge them together.
     * 
     * @param A the array to be sorted.
     * @param low the left most index of the sub array.
     * @param mid the middle index of the sub array.
     * @param high the right most index of the sub array.
     */
    public static void merge(int[] A, int low, int mid, int high ) {
        
        int[] M = new int[high-low+1]; // to store sorted and merged elements 

        int l = low; // left sub array index pointer
        int r = mid+1; // right sub array index pointer
        int m = 0; // merged array index pointer

        // sort and merge until index out of bound
        while (l <= mid && r <= high) {
            if (A[l] < A[r]) {
                M[m++] = A[l++];
            } else {
                M[m++] = A[r++];
            }
        }

        // add remaining elements
        while (l <= mid) {
            M[m++] = A[l++];
        }
        while (r <= high) {
            M[m++] = A[r++];
        }

        // copy back to A
        m = 0;
        for (int i = low; i <= high; i++) {
            A[i] = M[m++];
        }
        
    }

    // Test
    public static void main(String[] args) {
        
        int[] A = { 5, 1, 7, 3, 6, 2, 8, 4};

        mergeSort(A, 0, A.length-1);

        // display sorted array
        for (int e : A) {
            System.out.print(e + " ");
        }
        System.out.println();

    }
    
}
