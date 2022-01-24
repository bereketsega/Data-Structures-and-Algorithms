package datastructures.stacks;

/**
 * Stack implementation using Array.
 * 
 * @author Bereket Sega
 */
public class ArrayStack <T> {
    
    private Object[] array; // stores stack elements
    private int top;        // top element
    private int maxSize;    // maximum size 

    /**
     * Stack constructor 
     * @param maxSize maximum size of the stack
     */
    @SuppressWarnings("unchecked")
    ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = (T[]) new Object[maxSize];
        top = -1;
    }

    /**
     * Inserts a value onto the stack
     * @param val the value to be inserted
     */
    public void push(T val) {
        if (top < maxSize) {
            top++;
            array[top] = val;
        } 
    }

    /**
     * Gets the top element of the stack
     * @return the top element if the stack is not empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (!isEmpty())
            return (T) array[top];
        else 
            return null;
    }

    /**
     * Removes the top element from the stack
     * @return the removed element
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (!isEmpty()) {
            T removed = (T) array[top];
            array[top] = null;
            top--;
            return removed;
        }
        else {
            return null;
        }
    }

    /**
     * Checks if the stack is empty or not
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full or not
     * @return true if the stack is full
     */
    public boolean isFull() {
        return top + 1 == maxSize;
    }

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Displays the stack - Array[0] = top element
     */
    public void printStack() {
        
        System.out.print("[");
        if (!isEmpty()) {
            System.out.print(array[top]);
            for (int i = top - 1; i >= 0; i--) {
                if (array[i] != null) {
                    System.out.print(", " + array[i]);
                }
            }
        }
        System.out.println("]");
    }

    // Test
    public static void main(String[] args) {
        ArrayStack<Integer> aStack = new ArrayStack<>(2);
        aStack.push(23);
        aStack.push(2);
        aStack.pop();
        
        aStack.printStack();

        System.out.println( aStack.isFull());
        System.out.println(aStack.peek());
    }
    
}
