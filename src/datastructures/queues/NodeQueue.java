package datastructures.queues;

/**
 * Implementation of Queue using Node.
 * 
 * @author Bereket Sega
 */
public class NodeQueue <T> {

    private Node<T> front;  // tfirst element 
    private Node<T> tail;   // last element 
    private int items;      // number of items 

    /**
     * NodeQueue constructor
     */
    public NodeQueue() {
        items = 0;
    }

    /**
     * Inserts a value into the queue
     * @param val the value to be inserted
     */
    public void enqueue(T val) {
        
        Node<T> newItem = new Node<>(val);

        if (isEmpty()) {
            front = newItem;
            tail = newItem;
        }
        else {
            tail.behind = newItem;
            newItem.ahead = tail;
            tail = newItem;
        }

        items++;
    }

    /**
     * Removes the first element from the queue
     * @return the first element removed 
     */
    public T dequeue() {
        if (!isEmpty()) {
            Node<T> tempTail = front;
            if (items == 1) {
                front = tail = null;
            }
            else {
                front = front.behind;
                front.ahead = null;
            }

            items--;
            return tempTail.data;
        }
        else {
            return null;
        }
    }

    /**
     * Returns the first element of the queue
     * @return the first element of the queue
     */
    public T peek() {
        if (!isEmpty())
            return front.data;
        else
            return null;
    }

    /**
     * Returns the number of elements in the queue
     * @return the number of elements in the queue
     */
    public int size() {
        return items;
    }

    /**
     * Checks whether or not the queue is empty 
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return items == 0;
    }

    /**
     * Displays all elements in the queue as an Array - front = Array[0]
     */
    public void printQueue() {
        Node<T> tempFront = front;
        System.out.print("[");
        if (!isEmpty()) {
            System.out.print(tempFront.data);
            while (tempFront.behind != null) {
            System.out.print(", " + tempFront.behind.data);
            tempFront = tempFront.behind;
            }
        }
        System.out.println("]");
    }

    // Test
    public static void main(String[] args) {
        NodeQueue<Integer> nQueue = new NodeQueue<>();
        nQueue.enqueue(4);
        nQueue.enqueue(44);
        nQueue.enqueue(23);

        System.out.println(nQueue.dequeue());
        nQueue.printQueue();
        System.err.println(nQueue.size());
    }

}

class Node<T> {

    T data;
    Node<T> behind;
    Node<T> ahead;

    /**
     * Node constructor
     * @param data node value
     */
    Node(T data) {
        this.data = data;
        ahead = behind = null;
    }

}
