// Java Program Invert a Binary Tree using Iterative Level Order

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class InvertBinary {

    // Function to return the root of inverted tree
    static void mirror(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Traverse the tree, level by level
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // Swap the left and right subtree
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // Push the left and right node to the queue
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    // Print tree as level order
    static void levelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            System.out.print(curr.data + " ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        // Input Tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        mirror(root);

        // Mirror Tree:
        //       1
        //      / \
        //     3   2
        //        / \
        //       5   4
        levelOrder(root);
    }
}