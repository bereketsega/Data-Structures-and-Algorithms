package algorithms.searching;

/**
 * Binary Search implementation 
 * 
 * @author Bereket Sega
 */
public class BinarySearch {

    /**
     * searches a key in an array iterative approach
     * T/S: O(Logn)/O(1)
     * @param arr the array we're searching a key in
     * @param key the key we're searching
     * @return the index of key or -1 if not found 
     */
    public static int binarySearchIterative(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;        
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            // check middle
            if (key == arr[mid]) {
                return mid;
            }
            // check right side
            else if (key > arr[mid]) {
                low = mid + 1;
            }
            // left side
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * searches a key in an array recursive approach
     * T/S: O(Logn)/ O(Logn)
     * @param arr the array we're searching a key in
     * @param low the starting index of the search
     * @param high the ending index of the search
     * @param key the key we're searching
     * @return the index of key or -1 if not found 
     */
    public static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);
        // check middle
        if (key == arr[mid]) {
            return mid;
        }
        // check right
        else if (key > arr[mid]) {
            return binarySearchRecursive(arr, mid + 1, high, key);
        }
        // left side 
        else {
            return binarySearchRecursive(arr, low, mid - 1, key);
        }
    }
    
    // Test
    public static void main(String[] args) {
        
        int[] arr = {2,4,6,7,9,12,44};
        System.out.println(binarySearchIterative(arr, 12));
        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 9));

    }
    
}
