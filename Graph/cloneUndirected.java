import java.util.*;

// Definition for a Node
class Node {
    int val;
    ArrayList<Node> neighbors;

    Node() {
        neighbors = new ArrayList<>();
    }

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class cloneUndirected {

    // Map to hold original node to its copy
    static HashMap<Node, Node> copies = new HashMap<>();

    // Function to clone the graph using DFS
    public static Node cloneGraph(Node node) {
        // If the node is NULL, return NULL
        if (node == null) return null;

        // If node is not yet cloned, clone it
        if (!copies.containsKey(node)) {
            Node clone = new Node(node.val);
            copies.put(node, clone);

            // Recursively clone neighbors
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }

        // Return the clone
        return copies.get(node);
    }

    // Build graph
    public static Node buildGraph() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);

        node1.neighbors.addAll(Arrays.asList(node2, node3));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node1,node2, node4));
        node4.neighbors.addAll(Arrays.asList(node3));

        return node1;
    }

    // Compare two graphs for structural and value equality
    public static boolean compareGraphs(Node node1, Node node2, 
                                    HashMap<Node, Node> visited) {
        if (node1 == null || node2 == null)
            return node1 == node2;

        if (node1.val != node2.val || node1 == node2)
            return false;

        visited.put(node1, node2);

        if (node1.neighbors.size() != node2.neighbors.size())
            return false;

        for (int i = 0; i < node1.neighbors.size(); i++) {
            Node n1 = node1.neighbors.get(i);
            Node n2 = node2.neighbors.get(i);

            if (visited.containsKey(n1)) {
                if (visited.get(n1) != n2)
                    return false;
            } else {
                if (!compareGraphs(n1, n2, visited))
                    return false;
            }
        }

        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        Node original = buildGraph();

        // Clone the graph
        Node cloned = cloneGraph(original);

        // Compare original and cloned graph
        boolean result = compareGraphs(original, cloned, new HashMap<>());
        System.out.println(result ? "true" : "false");
    }
}