package datastructures.lists;

/**
 * Implementation of DoublyLinkedList
 * 
 * @author Bereket Sega
 */
public class DoublyLinkedList <T> {
    
    private DLLNode<T> head, tail; // first and last element
    private int size;              // number of elements
    
    /**
     * DoublyLinkedList constructor
     */
    DoublyLinkedList() {
        size = 0;
        head = tail = null;
    }

    /**
     * Inserts a value into the list
     * @param val the value to be inserted
     */
    public void insert(T val) {
        DLLNode<T> newItem = new DLLNode<T>(val);

        if (isEmpty()) {
            head = tail = newItem;
        }
        else {
            newItem.prev = tail;
            tail.next = newItem;
            tail = newItem;
        }
        size++;
    }

    /**
     * Removes a value from the list
     * @param val the value to be removed
     */
    public void remove(T val) {
        if (head.data == val) {
            removeFirst();
        }
        else if (tail.data == val) {
            removeLast();
        }
        else  {
            DLLNode<T> currHead = head;
            while(currHead.next != null) {
                if (currHead.data == val) {
                    currHead.prev.next = currHead.next;
                    currHead.next.prev = currHead.prev;
                    size--;
                    break;
                }
                currHead = currHead.next;
            }
        }
    }

    /**
     * Removes the first element
     */
    public void removeFirst() {
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            }
            else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
    }

    /**
     * Removes the last element
     */
    public void removeLast() {
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            }
            else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
    }

    /**
     * Returns the first element
     * @return the first element
     */
    public T peek() {
        return head == null ? null : head.data;
    }

    /**
     * Reverse the list
     */
    public void reverse() {
        DLLNode<T> curr = tail = head;
        DLLNode<T> prev = null;

        while (curr != null) {
            DLLNode<T> next = curr.next;
           
            curr.next = prev;
            curr.prev = next;
            
            prev = curr;
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
     * Checks whether the list is empty or not
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Displays the list as an Array - head = Array[0]
     */
    public void printList() {
        System.out.print("[");
        if (!isEmpty()) {
            DLLNode<T> curr = head;
            System.out.print(curr.data);
            while (curr.next != null) {
                System.out.print(", " + curr.next.data);
                curr = curr.next;
            }
        }
        System.err.println("]");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dLL = new DoublyLinkedList<>();
        
        dLL.insert(23);
        dLL.insert(93);
        dLL.insert(29);

        System.out.println(dLL.peek());

        dLL.printList();
    }
}

class DLLNode <T> {
    
    T data;
    DLLNode<T> next, prev;

    /**
     * DLLNode constructor
     * @param data the Node value
     */
    DLLNode(T data) {
        this.data = data;
        next = prev = null;
    }
}

