// Java program to find LCA of given node in BST
// Using Properties of BST and Iteration

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class LCABST {

    // Function to find LCA of n1 and n2, assuming
    // that both nodes n1 and n2 are present in BST
    static Node LCA(Node root, Node n1, Node n2) {
      
        while (root != null) {
          
            // If both n1 and n2 are smaller than root,
            // then LCA lies in left
            if (root.data > n1.data && root.data > n2.data)
                root = root.left;

            // If both n1 and n2 are greater than root,
            // then LCA lies in right
            else if (root.data < n1.data && root.data < n2.data)
                root = root.right;

            // Else Ancestor is found
            else
                break;
        }
      
        return root;
    }

    public static void main(String[] args) {
        // Representation of input BST:
        //            20
        //           /  \
        //          8    22
        //        /   \
        //       4    12
        //           /   \
        //         10    14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node n1 = root.left.left; // Node 4
        Node n2 = root.left.right.right; // Node 14

        Node res = LCA(root, n1, n2);
        System.out.println(res.data);
    }
}