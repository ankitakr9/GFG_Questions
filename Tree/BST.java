// Java program to check if a tree is BST using Inorder Traversal

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BST {
  
    // Recursive Function for inorder traversal
    static boolean inorder(Node root, int[] prev) {
        if (root == null)
            return true;

        // Recursively check the left subtree
        if (!inorder(root.left, prev))
            return false;

        // Check the current node value against the previous value
        if (prev[0] >= root.data)
            return false;

        // Update the previous value to the current node's value
        prev[0] = root.data;

        // Recursively check the right subtree
        return inorder(root.right, prev);
    }

    // Function to check if the tree is a valid BST
    static boolean isBST(Node root) {
        int[] prev = {Integer.MIN_VALUE};
        return inorder(root, prev);
    }

    public static void main(String[] args) {
      
        // Create a sample binary tree
        //     10
        //    /  \
        //   5    20
        //        / \
        //       9   25
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(9);
        root.right.right = new Node(25);
      
      	if (isBST(root)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}