package datastructures.stacks;

/**
 * Stack implementation using Node.
 * 
 * @author Bereket Sega
 */
public class NodeStack <T> {

    private Node<T> top;   // top element of the stack
    private int items;     // number of items in the stack

    /**
     * Stack Constructor
     */
    NodeStack() {
        items = 0;
    }

    /**
     * Inserts a value onto the stack
     * @param val the value to be inserted
     */
    public void push(T val) {

        Node<T> newItem = new Node<>(val);

        if (isEmpty()) {
            top = newItem;
        }
        else {
            top.above = newItem;
            newItem.below = top;
            top = newItem;
        }
        items++;
    }

    /**
     * Removes the top value from the stack
     * @return the removed top value of the stack
     */
    public T pop() {
        if (!isEmpty()) {

            T tempTop = peek();

            if (items == 1) {
                top = null;
            }
            else {
                top = top.below;
                top.above = null;
            }

            items--;

            return tempTop;
        }
        else {
            return null;
        }
    }

    /**
     * Returns the top value of the stack
     * @return the top value of the stack
     */
    public T peek() {
        if (!isEmpty()) 
            return top.data;
        else 
            return null;
    }

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    public int size() {
        return items;
    }

    /**
     * Returns whether or not the stack has at least one element 
     * @return true if the stack has at least one element
     */
    public boolean isEmpty() {
        return items == 0;
    }

    /**
     * Displays the stack as Array where top = Array[0]
     */
    public void printStack() {
        
        Node<T> tempTop = top;

        System.out.print("[");
        if (!isEmpty()) {
            System.out.print(tempTop.data);
            while (tempTop.below != null) {
                System.out.print(", " + tempTop.below.data);
                tempTop = tempTop.below;
            }
        }
        System.out.println("]");
    }

    // Test
    public static void main(String[] args) {

        NodeStack<Integer> nStack = new NodeStack<>();

        nStack.push(9);
        nStack.push(8);
        nStack.push(3);

        System.out.println(nStack.pop());
        System.out.println(nStack.peek());

        nStack.printStack();
    }

}

class Node <T> {

    T data;
    Node<T> above, below;

    /**
     * Node Constructor
     * @param data the Node value
     */
    Node(T data) {
        this.data = data;
        above = below = null;
    }
    
}