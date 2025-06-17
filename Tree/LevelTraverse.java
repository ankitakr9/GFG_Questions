import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    // Constructor to initialize a new node
    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

// Iterative method to perform level order traversal
public class LevelTraverse {
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        // Enqueue Root
        q.offer(root);
        int currLevel = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                // Add front of queue and remove it from queue
                Node node = q.poll();
                res.get(currLevel).add(node.data);

                // Enqueue left child
                if (node.left != null)
                    q.offer(node.left);

                // Enqueue right child
                if (node.right != null)
                    q.offer(node.right);
            }
            currLevel++;
        }
        return res;
    }

    public static void main(String[] args) {
        //      5
        //     / \
        //   12   13
        //   /  \    \
        //  7    14   2
        // /  \   /  \  / \
        //17 23 27  3  8  11

        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);

        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        // Perform level order traversal and get the result
        List<List<Integer>> res = levelOrder(root);

        // Print the result in the required format
        for (List<Integer> level : res) {
            System.out.print("[");
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i));
                if (i < level.size() - 1) System.out.print(", ");
            }
            System.out.print("] ");
        }
    }
}