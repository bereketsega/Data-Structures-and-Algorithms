package datastructures.lists;

/**
 * Implementation of Singly Linked List
 * 
 * @author Bereket Sega
 */
public class SinglyLinkedList <T> {

    private SLLNode<T> head;    // first element
    private SLLNode<T> tail;    // last element
    private int size;           // number of elements 
    
    /**
     * SinglyLinkedList constructor
     */
    SinglyLinkedList() {
        size = 0;
        head = tail = null;
    }

    /**
     * Inserts a value to the list
     * @param val the value to be inserted
     */
    public void insert(T val) {
        
        SLLNode<T> newSLLNode = new SLLNode<>(val);

        if (peek() == null) {
            head = newSLLNode;
            tail = newSLLNode;
        }
        else {
            tail.next = newSLLNode;
            tail = newSLLNode;
        }

        size++;
    }

    /**
     * Returns the first element
     * @return the first element or null if not found
     */
    public T peek(){
        return (!isEmpty()) ? head.data : null;
    }

    /**
     * Checks if the list is empty or not
     * @return true if the list is empty else false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the element with the value of val
     * @param val the element value to be removed
     */
    public void remove(T val) {
        
        if (peek() == val) {
            pop();
        }
        else {

            SLLNode<T> curr = head;

            while (curr != null) {
                if (curr.next.data == val) {
                    curr.next = curr.next.next;
                    size--;
                    break;
                }
                curr = curr.next;
            }
        }

    }

    /**
     * Removes the first element 
     */
    public void pop() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    /**
     * Reverses the list
     */
    public void reverse() {

        SLLNode<T> curr = head;
        SLLNode<T> prev = null;

        while(curr != null) {
            SLLNode<T> next = head.next;

            curr.next = prev;
            prev = head;
            head = next;

            curr = next;
        }
        head = prev;
    }

    /**
     * Returns the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Displays the list as an Array: head = Array[0]
     */
    public void printList() {
        System.out.print("[");
        if (!isEmpty()) {
            SLLNode<T> curr = head;
            System.out.print(curr.data);
            while (curr.next != null) {
                System.out.print(", " + curr.next.data);
                curr = curr.next;
            }
        }
        System.out.println("]");
    }

    // Test
    public static void main(String[] args) {
        
        SinglyLinkedList<Integer> sLL = new SinglyLinkedList<>();

        sLL.insert(45);
        sLL.insert(23);
        sLL.insert(34);
        sLL.insert(93);

        sLL.printList();    
        System.out.println(sLL.peek());

        sLL.reverse();

        sLL.pop();
        
        sLL.printList();
        System.err.println(sLL.peek());

    }

}

class SLLNode <T> {
    
    T data;
    SLLNode<T> next;

    /**
     * SLLNode constructor
     * @param data the value of the node
     */
    SLLNode(T data) {
        this.data = data;
        next = null;
    }
}
