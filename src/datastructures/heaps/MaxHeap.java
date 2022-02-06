package datastructures.heaps;

/**
 * Implementation of max heap
 * 
 * @author Bereket Sega
 */
public class MaxHeap {
    
    private int[] heapArr; // to store heap elements
    private int MAX;       // to store max size of heap
    private int size;      // to count elements in the heap

    /**
     * Max Heap constructor sets the maximum size 
     * and initialize heap array with maximum size
     * @param size the maximum size of the heap
     */
    MaxHeap(int size) {
        MAX = size;
        this.size = 0;
        heapArr = new int[MAX];
    }

    /**
     * inserts an element into the heap
     * @param val the value to be inserted
     */
    public void push(int val) {
        // no room to insert
        if (size == MAX) {return;}

        heapArr[size] = val; // new element at the right most index

        int curr = size; // to traverse
        // move up new element until its no longer greater than its parent
        while (heapArr[curr] > heapArr[parent(curr)]) {
            swap(parent(curr), curr); 
            curr = parent(curr); // update index of new element
        }
        size++;

    }

    /**
     * removes and returns the max element of the heap
     * @param val the value to be removed
     * @return the removed value or -1 if not found
     */
    public int pop(int val) {
        // find the index of node to be deleted
        for (int i = 0; i < size; i++) {
            if (heapArr[i] == val) {
                // delete
                int temp = heapArr[i];
                // replace root with right most node
                heapArr[i] = heapArr[size-1]; 
                // heapify the nodes
                maxHeapify(i);
                size--;
                return temp;
            }
        }
        return -1;

    }

    /**
     * returns the root of the heap
     * @return the max element of the heap
     */
    public int peek() {
        return heapArr[0];
    }

    /**
     * allows to keep the max heap properties
     * @param index the node where we start checking
     */
    private void maxHeapify(int index){
        
        int max = index;

        int left = left(index); 
        int right = right(index); 

        // index out of bounds
        if (left >= size || right >= size) {
            return;
        }
        // when left child is greater than parent node
        if (heapArr[left] > heapArr[max]) {
            max = left;
        }
        // when right child is greater than both parent and left child nodes
        if (heapArr[right] > heapArr[max]) {
            max = right;
        }
        // if any of the childrens are greater than parent node
        if (max != index) {
            // swap the max of left and right with parent node
            swap(index, max);
            // recurse until index out of bound or parent is max
            maxHeapify(max);
        }

    }

    /**
     * swaps index1 with index2 elements
     * @param parent first index
     * @param child second index
     */
    private void swap(int parent, int child) {
        int temp = heapArr[parent];

        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
    }

    /**
     * returns the parent node index
     * @param i index of child of parent node
     * @return index of parent node
     */
    public int parent(int i) {
        return (i-1)/2;
    }
    
    
    /**
     * returns the left child node index
     * @param i index of parent node of left child
     * @return index of left child node
     */
    private int left(int i) {
        return (2*i)+1;
    }
    
    /**
     * returns the right child node index
     * @param i index of parent node of right child
     * @return index of right child node
     */
    private int right(int i) {
        return (2*i)+2;
    }

    /**
     * returns the number of elements in the heap
     * @return the number of elements in the heap
     */
    public int size() {
        return size;
    }

    // Test
    public static void main(String[] args) {
        
        MaxHeap max = new MaxHeap(7);
        
        max.push(1);
        max.push(20);
        max.push(3);
        max.push(4);
        max.push(9);

        max.pop(20);

        for (int i = 0; i < max.size(); i++) {
            System.out.println(max.heapArr[i]);
        }
    }

}
