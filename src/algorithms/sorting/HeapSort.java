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
    private static void sort(int[] arr) {
        int size = arr.length-1;
        // swap head of heap with last node until size = 0
        while (size >= 0) {
            pop(arr, size); // replace head with tail of heap
            size--;
            heapify(arr, size, 0); // keeps heap property
            
        }
    }

    /**
     * swaps head element with right most node
     * @param arr the array we are swapping elements
     * @param size last elements in the array
     */
    private static void pop(int[] arr, int size) {
        // swap
        int temp = arr[0];
        arr[0] = arr[size];
        arr[size] = temp;
    }
    
    /**
     * builds a heap and sort it
     * T/S : O(nlogn)/O(1)
     * @param arr the array to be sorted
     */
    public static void heapSort(int[] arr) {
        // build a heap from arr
        buildHeap(arr);

        // sort the heap
        sort(arr);
    }

    /**
     * builds max heap from an array
     * @param arr the array to be a heap
     */
    private static void buildHeap(int[] arr) {

        // build heap 
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
                heapify(arr, arr.length-1, i);
        }
    }

    /**
     * swaps index1 with index2 elements
     * @param parent first index
     * @param child second index
     */
    private static void swap(int[] arr, int parent, int child) {
        int temp = arr[parent];

        arr[parent] = arr[child];
        arr[child] = temp;
    }

    private static void heapify(int[] arr, int size, int index) {
        
        int max = index;

        int left = (2*index)+1; // left child of index node
        int right = (2*index)+2; // right child of index node

        // when left child is greater than parent node
        if (left <= size && arr[left] > arr[max]) {
            max = left;
        }
        // when right child is greater than both parent and left child nodes
        if (right <= size && arr[right] > arr[max]) {
            max = right;
        }
        // if any of the childrens are greater than parent node
        if (max != index) {
            // swap the max of left and right with parent node
            swap(arr, index, max);
            // recurse until index out of bound or parent is max
            heapify(arr, size, max);
        }
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {51,21,46,7,2,73,22};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
