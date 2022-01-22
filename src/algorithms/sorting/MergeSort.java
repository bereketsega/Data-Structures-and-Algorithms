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

        int[] res = new int[left.length + right.length]; // stores the sorted array

        int leftP, rightP, resP; // left, right, and res arrays' index pointers
        leftP = rightP = resP = 0;

        // elements exist in either left or right subarrays 
        while (leftP < left.length || rightP < right.length) {

            // case: elements exist in both left and right subarrays 
            if (leftP < left.length && rightP < right.length) {

                // case: left element is less than right element
                if (left[leftP] < right[rightP]) {
                    res[resP++] = left[leftP++];
                }
                // case: right element is less than left element
                else if (right[rightP] < left[leftP]) {
                    res[resP++] = right[rightP++]; 
                }
                // case: left and right element are equal
                else {
                    res[resP++] = left[leftP++];
                    res[resP++] = right[rightP++];
                }

            }
            // case: elements exist only in left subarray
            else if (leftP < left.length) {
                res[resP++] = left[leftP++]; 
            }
            // case: element exist only in right subarray
            else if (rightP < right.length) {
                res[resP++] = right[rightP++]; 
            }
        }

        return res;

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
