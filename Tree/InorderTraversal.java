// Java code to print Inorder Traversal
// of Binary Tree using Morris Traversal
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class InorderTraversal {

    // Function for inorder traversal 
    // using Morris Traversal
    static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
              
                // If no left child, visit this node 
                // and go right
                res.add(curr.data);
                curr = curr.right;
            } 
            else {
              
                // Find the inorder predecessor of curr
                Node prev = curr.left;
                while (prev.right != null && 
                                   prev.right != curr) {
                    prev = prev.right;
                }

                // Make curr the right child of its 
                // inorder predecessor
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } 
                else {
                  
                    // Revert the changes made in 
                    // the tree structure
                    prev.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // Representation of input binary tree:
        //           1
        //          / \
        //         2   3
        //        / \  
        //       4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> res = inOrder(root);

         for (int data : res) {
            System.out.print(data + " ");
        }
    }
}