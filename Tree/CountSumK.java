// Java Program to Count all K Sum Paths in Binary Tree
// Using Prefix sum Technique

import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class CountSumK {
  
    // Function to find paths in the tree which have their sum equal to K
    static int countPathsUtil(Node node, int k, int currSum, 
                              	HashMap<Integer, Integer> prefSums) {
        if (node == null)
            return 0;

        int pathCount = 0;
        currSum += node.data;

        // Pathsum from root to current node is equal to k
        if (currSum == k)
            pathCount++;

        // The count of curr_sum − k gives the number of paths 
        // with sum k up to the current node
        pathCount += prefSums.getOrDefault(currSum - k, 0);

        // Add the current sum into the hashmap
        prefSums.put(currSum, prefSums.getOrDefault(currSum, 0) + 1);

        pathCount += countPathsUtil(node.left, k, currSum, prefSums);
        pathCount += countPathsUtil(node.right, k, currSum, prefSums);

        // Remove the current sum from the hashmap
        prefSums.put(currSum, prefSums.get(currSum) - 1);

        return pathCount;
    }

    // Function to find the paths in the tree which have their sum equal to K
    static int countAllPaths(Node root, int k) {
        HashMap<Integer, Integer> prefSums = new HashMap<>();
      
        return countPathsUtil(root, k, 0, prefSums);
    }

    public static void main(String[] args) {
        // Create a sample tree:
        //        8
        //      /  \
        //     4    5
        //    / \    \
        //   3   2    2
        //  / \   \
        // 3  -2   1

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        int k = 7;
        System.out.println(countAllPaths(root, k));
    }
}