// Java program to find a pair with given sum in a Balanced BST
// Using Inorder Traversal

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class PairSum {
    
    // Function to perform Inorder traversal and store the 
    // elements in an array
    static void inorderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        inorderTraversal(root.left, inorder);

        // Store the current node's value
        inorder.add(root.data);

        inorderTraversal(root.right, inorder);
    }

    // Function to find if there exists a pair with a 
    // given sum in the BST
    static boolean findTarget(Node root, int target) {
      
        // Create an auxiliary array and store Inorder traversal
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Use two-pointer technique to find the pair with given sum
        int left = 0, right = inorder.size() - 1;

        while (left < right) {
            int currentSum = inorder.get(left) + inorder.get(right);

            // If the pair is found, return true
            if (currentSum == target)
                return true;

            // If the current sum is less than the target, 
            // move the left pointer
            if (currentSum < target)
                left++;
          
            // If the current sum is greater than 
            // the target, move the right pointer
            else
                right--;
        }

        return false;
    }

    public static void main(String[] args) {
        // Constructing the following BST:
        //         7
        //        / \
        //       3   8
        //      / \   \
        //     2   4   9

        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        int target = 12;

        // Check if there are two elements in the BST
        // that added to "target"
        if (findTarget(root, target))
            System.out.println("True");
        else
            System.out.println("False");
    }
}