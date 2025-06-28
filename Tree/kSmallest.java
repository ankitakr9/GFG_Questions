// Java program to find kth 
// smallest value in BST

class Node {
    int data;
    int lCount;
    Node left, right;

    Node(int x, int l) {
        data = x;
        lCount = l;
        left = null;
        right = null;
    }
}

class kSmallest {

    // Recursive function for inorder traversal of the tree  
    // and find its kth smallest value.
    // Returns -1 if value is not found.
    static int kthSmallestRecur(Node root, int[] k) {
        if (root == null) return -1;

        // Search left subtree
        if (k[0] < root.lCount + 1) {
            return kthSmallestRecur(root.left, k);
        }
        
        // return curr node 
        else if (k[0] == root.lCount + 1) {
            return root.data;
        }
        
        // decrement k by (lCount+1) and 
        // search right subtree
        else {
            k[0] = k[0] - (root.lCount + 1);
            return kthSmallestRecur(root.right, k);
        }
    }

    // Function to find kth smallest value in BST.
    static int kthSmallest(Node root, int k) {
        int[] kRef = {k};
        return kthSmallestRecur(root, kRef);
    }

    public static void main(String[] args) {

        // Binary search tree
        //      20
        //    /   \
        //   8     22
        //  / \
        // 4   12
        //    /  \
        //   10   14
        Node root = new Node(20, 5);
        root.left = new Node(8, 1);
        root.right = new Node(22, 0);
        root.left.left = new Node(4, 0);
        root.left.right = new Node(12, 1);
        root.left.right.left = new Node(10, 0);
        root.left.right.right = new Node(14, 0);
        int k = 3;

        System.out.println(kthSmallest(root, k));
    }
}