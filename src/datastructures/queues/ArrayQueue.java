package datastructures.queues;

/**
 * Implementation of Queue using Array.
 * 
 * @author Bereket Sega
 */
public class ArrayQueue <T> {
    
    private Object[] array; // store queue elements
    private int front;      // first element
    private int rear;       // last element
    private int count;      // number of elements
    private int maxSize;    // maximum size

    /**
     * Queue constructor
     * @param maxSize maximum size of the queue
     */
    @SuppressWarnings ("unchecked")
    ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = (T[]) new Object[maxSize];
        front = count = 0;
        rear = -1;
    }

    /**
     * Inserts a value into rear of the queue
     * @param val value to be inserted
     */
    public void enqueue(T val) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            array[rear] = val;
            count++;
        }
    }

    /**
     * Removes the first element
     * @return the removed element
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (!isEmpty()) {

            T removed = (T) array[front];
            front = (front + 1) % maxSize;
            count--;
            return removed;
        }
        else {
            return null;
        }
    }

    /**
     * Retures the first element 
     * @return the first element if it exists
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (!isEmpty())
            return (T) array[front];
        else    
            return null;
    }

    /**
     * Returns the number of elements in the queue
     * @return the number of elements in the queue
     */
    public int size() {
        return count;
    }

    /**
     * Checks if the queue is empty or not
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks if the queue is full or not
     * @return true if the queue is full
     */
    public boolean isFull() {
        return count == maxSize;
    }

    /**
     * Displays the queue - Array[0] = frist element
     */
    public void printQueue() {
        
        System.out.print("[");
        if (!isEmpty()) {
            System.out.print(array[front]);
            for (int i = front + 1; i < array.length; i++) {
                if (array[i] != null) {
                    System.out.print(", " + array[i]);
                }
            }
        }
        System.out.println("]");
    }

    // Test
    public static void main(String[] args) {

        ArrayQueue<Integer> aQueue = new ArrayQueue<>(3);

        aQueue.enqueue(3);
        aQueue.enqueue(253);
        
        aQueue.dequeue();
        
        aQueue.printQueue();
    }

}
