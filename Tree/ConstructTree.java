// Java program to construct tree using 
// inorder and preorder traversals

import java.util.*;    

class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class ConstructTree {
	
	// Print tree as level order
    static void printLevelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> qq = new LinkedList<>();
        qq.add(root);
        int nonNull = 1;

        while (!qq.isEmpty() && nonNull > 0) {
            Node curr = qq.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            nonNull--;

            System.out.print(curr.data + " ");
            qq.add(curr.left);
            qq.add(curr.right);
            if (curr.left != null)
                nonNull++;
            if (curr.right != null)
                nonNull++;
        }
    }

    // Recursive function to build the binary tree.
    static Node buildTreeRecur(Map<Integer, Integer> mp, 
                               int[] preorder, 
                               int[] preIndex, int left,
                               int right) {

        // For empty inorder array, return null
        if (left > right)
            return null;

        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;

        // create the root Node
        Node root = new Node(rootVal);

        // find the index of Root element in the in-order array.
        int index = mp.get(rootVal);

        // Recursively create the left and right subtree.
        root.left = buildTreeRecur(mp, preorder, preIndex,
                                   left, index - 1);
        root.right = buildTreeRecur(mp, preorder, preIndex, 
                                    index + 1, right);

        return root;
    }

    // Function to construct tree from its inorder and preorder traversals
    static Node buildTree(int[] inorder, int[] preorder) {

        // Hash map that stores index of a root element in inorder array
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            mp.put(inorder[i], i);

        int[] preIndex = {0};
        return buildTreeRecur(mp, preorder, preIndex, 
                              0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};
        Node root = buildTree(inorder, preorder);

        printLevelOrder(root);
    }
}