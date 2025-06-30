// Java code for correcting a BST where two nodes are swapped,
// Using recursion

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class NodeSwap {
  	static void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    // Recursive Function for inorder traversal to find out 
    // the two swapped nodes.
    static void correctBSTUtil(Node root, Node[] first,
                               Node[] middle, 
                                Node[] last, Node[] prev) {
        if (root == null)
            return;

        // Recur for the left subtree
        correctBSTUtil(root.left, first, middle, last, prev);

        // If this node is smaller than the previous node, 
        // it's violating the BST rule.
        if (prev[0] != null && root.data < prev[0].data) {

            // If this is the first violation, mark these 
            // two nodes as 'first' and 'middle'
            if (first[0] == null) {
                first[0] = prev[0];
                middle[0] = root;
            }

            // If this is the second violation, 
            // mark this node as last
            else
                last[0] = root;
        }

        // Mark this node as previous
        prev[0] = root;

        // Recur for the right subtree
        correctBSTUtil(root.right, first, middle, last, prev);
    }

    // Function to fix the given BST, where two nodes are swapped.
    static void correctBST(Node root) {
        // Initialize pointers needed for correctBSTUtil()
        Node[] first = {null}, middle = {null}, 
               last = {null}, prev = {null};

        // Set the pointers to find out two nodes
        correctBSTUtil(root, first, middle, last, prev);

        // Fix (or correct) the tree
        if (first[0] != null && last[0] != null)
            swap(first[0], last[0]);
        else if (first[0] != null && middle[0] != null)
            swap(first[0], middle[0]);
    }

    // Print tree as level order
    static void printLevelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nonNull = 1;

        while (!queue.isEmpty() && nonNull > 0) {
            Node curr = queue.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            nonNull--;

            System.out.print(curr.data + " ");
            queue.add(curr.left);
            queue.add(curr.right);
            if (curr.left != null)
                nonNull++;
            if (curr.right != null)
                nonNull++;
        }
    }

    public static void main(String[] args) {
        // Constructing the tree with swapped nodes
        //       6
        //     /  \
        //    10   2
        //   / \  / \
        //  1  3 7  12
        // Here, 10 and 2 are swapped

        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        correctBST(root);
        printLevelOrder(root);
    }
}