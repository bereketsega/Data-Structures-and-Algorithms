package algorithms.sorting;

/**
 * Heap Sort algorithm implementation
 * 
 * @author Bereket Sega
 */
public class HeapSort {
   
    /**
     * sorts a heap built from array
     * @param arr the heap array
     */
    private static void sort(int[] arr, int n) {
        
        for (int i = n-1; i > 0; i--) {
            // move head to the end
            swap(arr, i, 0);

            // keep heap property
            heapify(arr, i-1, 0);
        }
    }
    
    /**
     * builds a heap and sort it
     * T/S : O(nlogn)/O(1)
     * @param arr the array to be sorted
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // build a heap from arr
        buildHeap(arr, n);

        // sort the heap
        sort(arr, n);
    }

    /**
     * builds max heap from an array
     * @param arr the array to be a heap
     */
    private static void buildHeap(int[] arr, int n) {

        // build heap 
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * swaps index1 with index2 elements
     * @param i1 first index
     * @param i2 second index
     */
    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];

        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * builds a max heap 
     * 
     * @param arr the array the max heap to be built on
     * @param n length of the array
     * @param i the index to heapify
     */
    private static void heapify(int[] arr, int n, int i) {
        
        int root = i;
        int left = (2*i)+1; // left child of root node
        int right = (2*i)+2; // right child of root node

        // check if left child is greater than root 
        if (left <= n && arr[left] > arr[root]) {
            root = left;
        }

        // check if right child is greater than either left or root 
        if (right <= n && arr[right] > arr[root]) {
            root = right;
        }

        // check if root node is no longer the max
        if (root != i) {
            // swap the max of left and right with parent node
            swap(arr, root, i);
            // heapify until index out of bound or parent is max
            heapify(arr, n, root);
        }

    }

    // Test
    public static void main(String[] args) {
        int[] arr = {51,21,46,7,2,73,22};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
