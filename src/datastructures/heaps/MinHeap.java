package datastructures.heaps;

/**
 * Implementation of min heap
 * 
 * @author Bereket Sega
 */
public class MinHeap {

    private int[] heapArr; // stores the heap nodes
    private int MAX;       // maximum nodes in a heap
    private int size;      // number of elements in a heap

    /**
     * MinHeap constructor sets size to zero and
     * creates an array of size MAX
     * @param size
     */
    MinHeap(int size) {
        MAX = size;
        this.size = 0;
        heapArr = new int[MAX];
    }

    /**
     * swaps index1 and index 2
     * @param parent index1
     * @param child index2
     */
    public void swap(int parent, int child) {
        int temp = heapArr[parent];
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
    }

    public void push(int val) {

        heapArr[size] = val; // store new node in right most index

        // heapify 
        int curr = size;
        while(heapArr[curr] < heapArr[parent(curr)]) {
            swap(parent(curr), curr);
            curr = parent(curr); // update index of curr
        }
        size++;

    };

    /**
     * allows the heap to keep the min heap properties
     * @param index the index where we start fixing
     */
    public void minHeapify(int index) {

        int min = index;

        int left = left(index); 
        int right = right(index); 

        // index out of bounds
        if (left >= size || right >= size) {
            return;
        }
        // when left child is less than parent node
        if (heapArr[left] < heapArr[min]) {
            min = left;
        }
        // when right child is less than both parent and left child nodes
        if (heapArr[right] < heapArr[min]) {
            min = right;
        }
        // if any of the childrens are less than parent node
        if (min != index) {
            // swap the min of left and right with parent node
            swap(index, min);
            // recurse until index out of bound or parent is min
            minHeapify(min);
        }

    }

    /**
     * removes and return val from the heap
     * @param val the value to be removed
     * @return val or 0 if val does not exist
     */
    public int pop(int val) {
        // check if the node exists
        for (int i = 0; i < size; i++) {
            if (heapArr[i] == val) {
                int temp = heapArr[i];
                // swap i'th node with right most node
                heapArr[i] = heapArr[size-1];
                minHeapify(i); // heapify the nodes
                size--;
                return temp;
            }
        }
        
        return 0;
    }

    /**
     * returns the root of the heap
     * @return min value of the heap
     */
    public int peek() {return heapArr[0];}

    /**
     * returns the index of parent of i'th node
     * @param i node index in the heap 
     * @return parent of i'th node
     */
    public int parent(int i) {
        return (i-1)/2;
    }

    /**
     * returns the index of left child of i'th node
     * @param i node index in the heap 
     * @return left child of i'th node
     */
    public int left(int i) {
        return (i*2)+1;
    }

    /**
     * returns the index of right child of i'th node
     * @param i node index in the heap 
     * @return right child of i'th node
     */
    public int right(int i) {
        return (i*2)+2;
    }

    /**
     * returns the amount of elements in the heap
     * @return the size of the heap
     */
    public int size() {
        return size;
    }

    // Test
    public static void main(String[] args) {
        
        MinHeap min = new MinHeap(10);
        
        min.push(4);
        min.push(8);
        min.push(3);
        min.push(1);
        min.push(-2);

        min.pop(-2);
        min.pop(1);

        for (int i = 0; i < min.size(); i++) {
            System.out.println(min.heapArr[i]);
        }

    }
}
