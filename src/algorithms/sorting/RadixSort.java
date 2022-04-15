package algorithms.sorting;

import java.util.Arrays;

/**
 * Implementation of RadixSort algorithm.
 */
public class RadixSort {

    /**
     * returns the maximum element from an array 
     * 
     * @param A the array to find max for
     * @return the maximum element from an array
     */
    private static int max(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    /**
     * sorts an array using counting sort for each digit of the hightest number
     * T/S:O(n*m)/O(n+m), where m = hightest number digit
     * 
     * @param A the array to be sorted
     */
    public static void radixSort(int[] A) {

        int max = max(A);

        for (int digit = 1; max/digit > 0; digit*=10) {
        
            int[] count = new int[max+1];
            int[] res = new int[A.length+1];

            for (int i = 0; i < count.length; i++) {
                count[i] = 0;
            }

            for (int i = 0; i < A.length; i++) {
                int digitNum = (A[i] / digit) % 10;
                count[digitNum]++;
            }

            for (int i = 1; i < count.length; i++) {
                int prev = count[i-1];
                count[i] += prev;
            }

            for (int i = A.length-1; i >= 0; i--) {
                int digitNum = (A[i] / digit) % 10;
                res[count[digitNum]-1] = A[i];
                count[digitNum]--;
            }

            for (int i = 0; i < A.length; i++) {
                A[i] = res[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {32, 5, 12, 75, 334, 23, 613, 0, 43, 92, 26};
        
        radixSort(A);

        System.out.println(Arrays.toString(A));
    }
    
}
