// Java program to serialize and 
// deserialize a binary tree.
import java.util.ArrayList;
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

class Serialize {
    
    // Main function to serialize a tree.
    static ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // If curr node is null,
            // append -1 to result.
            if (curr == null) {
                arr.add(-1);
                continue;
            }

            // else push its value into
            // result and push left and right
            // child nodes into queue.
            arr.add(curr.data);
            q.add(curr.left);
            q.add(curr.right);
        }

        return arr;
    }

    // Main function to deserialize a tree.
    static Node deSerialize(ArrayList<Integer> arr) {

        // base case
        if (arr.get(0) == -1) return null;

        // create root node and push 
        // it into queue
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty()) {
            Node curr = q.poll();

            // If left node is not null
            if (arr.get(i) != -1) {
                Node left = new Node(arr.get(i));
                curr.left = left;
                q.add(left);
            }
            i++;

            // If right node is not null
            if (arr.get(i) != -1) {
                Node right = new Node(arr.get(i));
                curr.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
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

        // Create a hard coded tree
        //       10
        //     /    \
        //    20    30
        //  /   \
        // 40  60
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        ArrayList<Integer> arr = serialize(root);
        Node res = deSerialize(arr);

        printLevelOrder(res);
    }
}