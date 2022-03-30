package algorithms.sorting;

/**
 * Implementation of Merge Sort Algorithm
 * 
 * @author Bereket Sega
 */
public class MergeSort {
    
    /**
     * sortes an array in non-decreasing order using divide and conquer technique
     * Complexity => Time/Space : O(nLogn)/O(n)
     * 
     * @param arr the array to be sorted
     * @return the sorted array
     */
    public static int[] mergeSort(int[] arr) {

        // base case: not enough elements in the array
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2; // middle index 

        // divide the array into left and right subarrays
        int[]left = new int[mid];
        int[] right = (arr.length % 2 == 0) ? new int[mid] : new int[mid+1]; 

        // populate the subarrays
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid+j];
        }

        // recursive step: divide and pupulate the subarrays until arr.length = 1
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right); // merged array

    }

    /**
     * merges two arrays in non-decreasing order
     * @param left left subarray
     * @param right right subarray
     * @return merged array of left and right subarrays
     */
    public static int[] merge(int[] left, int[] right) {

        // length of both arrays
        int leftLen = left.length;
        int rightLen = right.length;

        int[] sorted = new int[leftLen + rightLen]; // to store the sorted array

        int lI = 0, rI = 0, sI = 0; // left, right, and sorted arrays' index pointers

        // elements exist in both left and right subarrays 
        while (lI < leftLen && rI < rightLen) {

            // case: left element is less than right element
            if (left[lI] < right[rI]) {
                sorted[sI++] = left[lI++]; // add left element into sorted array
            }
            // case: right element is either equal or less than left element
            else {
                sorted[sI++] = right[rI++]; // add right element into sorted array
            }
        }

        // add all element of left array if exist
        while (lI < leftLen) {
            sorted[sI++] = left[lI++];
        }
        
        // add all element of right array if exist
        while (rI < rightLen) {
            sorted[sI++] = right[rI++];
        }

        return sorted;

    }

    // Test
    public static void main(String[] args) {
        
        int[] array = { 10, 14, 8, 11, 7, 16, 30, 25, 18};

        int[] sortedArray = mergeSort(array);

        // display sorted array
        for (int e : sortedArray) {
            System.out.print(e + " ");
        }
        System.out.println();

    }
    
}
