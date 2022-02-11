package algorithms.sorting;

/**
 * Implementation of counting sort.
 */
public class CountingSort {

    public static void countingSort(int[] arr) {
        
        int[] res = new int[arr.length + 1]; // to store the sorted elements

        // find the maximum value of arr
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // count array initialized with 0s
        int[] count = new int[max+1];
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // count each element in arr and store in count
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
       
        // count and store the cumulative sum
        for (int i = 1; i <= max; i++) {
            count[i] += count[i-1];
        }

        // find the index of each element in arr in count and insert
        // in result array
        for (int i = arr.length-1; i >= 0; i--) {  
            res[count[arr[i]] - 1] = arr[i]; 
            // decrease the count  
            count[arr[i]]--;
        }  

        //store the sorted elements into main array 
        for(int i = 0; i < arr.length; i++) {  
            arr[i] = res[i];  
         }  
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 1, 9, 4, 3, 6};
        countingSort(arr);
        
        // display after sorting
        for (int e : arr) {
            System.out.println(e);;
        }
    }

}
