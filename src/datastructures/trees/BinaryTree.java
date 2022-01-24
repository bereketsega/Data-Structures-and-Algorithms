package datastructures.trees;

/**
 * Implementation of Binary Tree
 * 
 * @author Bereket Sega
 */
public class BinaryTree { 
    
    private Node root; 

    /**
     * BinaryTree constructor sets root to null
     */
    BinaryTree() {
        root = null;
    }

    /**
     * Inserts a value into this tree
     * @param val the value to be inserted
     */
    public void put(int val) {

        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
        }
        else {

            Node parent = find(val);

            if (val < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
            }
            else {
                parent.right = newNode;
                parent.right.parent = parent;
            }
        }
    }

    /**
     * Finds the node with the value of val
     * @param val the value of node to be found
     * @return the node with val value or null if not found
     */
    public Node find(int val) {

        Node curr = root;

        while (curr != null) {
            if (val < curr.data) {
                if (curr.left == null)
                    return curr;
                curr = curr.left;
            }
            else if (val > curr.data) {
                if (curr.right == null) 
                    return curr;
                curr = curr.right;
            }
            else {
                return curr;
            }
        }

        return null;
    }

    /**
     * Removes the node with val value
     * @param val value of node to be removed
     */
    public void remove(int val) {
        
        Node removeNode = find(val);

        // no child
        if (removeNode.left == null && removeNode.right == null) {
            if (root == removeNode) {
                root = null;
            }
            else {
                removeNoChild(removeNode);
            }
        }

        // two children
        else if (removeNode.left != null && removeNode.right != null) {
            removeTwoChildren(removeNode);
        }

        // one child
        else if (removeNode.left != null || removeNode.right != null) {
            if (root == removeNode) {
                if (root.left != null) {
                    root.left.parent = null;
                    root = root.left;
                }
                else if (root.right != null) {
                    root.right.parent = null;
                    root = root.right;
                }
            }
            else {
                removeOneChild(removeNode);
            }
        }
    }

    /**
     * Helper method to remove a node with no child
     * @param removeNode the node to be removed
     */
    private void removeNoChild(Node removeNode) {
        if (removeNode.data < removeNode.parent.data) {
            removeNode.parent.left = null;
        }
        else {
            removeNode.parent.right = null;
        }
    }

    /**
     * Helper method to removed a node with one child
     * @param removeNode the node to be removed
     */
    private void removeOneChild(Node removeNode) {
        
        // case: node to be removed is left child
        if (removeNode.data < removeNode.parent.data) {
            if (removeNode.left != null) {
                removeNode.parent.left = removeNode.left;
                removeNode.left.parent = removeNode.parent;
            }
            else if (removeNode.right != null) {
                removeNode.parent.left = removeNode.right;
                removeNode.right.parent = removeNode.parent;
            }
        }

        // case: node to be removed is right child
        else if (removeNode.data > removeNode.parent.data) {
            if (removeNode.left != null) {
                removeNode.parent.right = removeNode.left;
                removeNode.left.parent = removeNode.parent;
            }
            else if (removeNode.right != null) {
                removeNode.parent.right = removeNode.right;
                removeNode.right.parent = removeNode.parent;
            }
        }

    }

    /**
     * Helper method to removed a node with two children
     * @param removeNode the node to be removed
     */
    private void removeTwoChildren(Node removeNode) {

        Node curr = removeNode.right; // start from the right

        if (curr.left == null) {
            curr.left = curr.parent.left;
        }
        else {
            // loop all the way to the left
            while(curr.left != null) {
                curr = curr.left;
            }
            // in case of the most left child has a right child
            if (curr.right != null) {
                curr.parent.left = curr.right;
                curr.right.parent = curr.parent;
            }
            else {
                curr.parent.left = null;
            }
            // transforming pointer
            curr.left = removeNode.left; 
            curr.right = removeNode.right;
            removeNode.right.parent = curr;
        }
      
        removeNode.left.parent = curr;
        
        // in case of node to removed is a root node 
        if (removeNode == root) {
            root = curr;
        }
        // in other cases
        else {
            curr.parent = removeNode.parent;
            if (curr.data <  removeNode.parent.data) {
                removeNode.parent.left = curr;
            }
            else if (removeNode.parent.data < curr.data) {
                removeNode.parent.right = curr;
            }
        }
    }

    /**
     * Prints the tree by preorder traversal
     * @param root the root of this tree
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    /**
     * Displays the tree by inorder traversal
     * @param root the root of this tree
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    /**
     * Displays the tree by postorder traversal
     * @param root the root of this tree
     */
    public void postOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * Returns the root of this tree
     * @return the root of this tree or null if it doesn't exist
     */
    public int peek() {
        return root != null ? root.data : null;
    }

    // Test
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
                              bt.put(50);
                  bt.put(25);
                                           bt.put(100);
        bt.put(10);
                        bt.put(32);
                                                   bt.put(400);
                  bt.put(26);
                                bt.put(46);
                            
      
        bt.remove(32);
        bt.inOrder(bt.root);
    }

}

class Node {
    
    int data;
    Node left, right, parent;

    /**
     * Node constructor sets data to val and left, right, parent to null
     * @param val
     */
    Node(int val) {
        data = val;
        left = right = parent = null;
    }
    
}
