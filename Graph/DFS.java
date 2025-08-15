import java.util.*;

public class DFS {
    // Recursive function for DFS traversal
    private static void
    dfsRec(ArrayList<ArrayList<Integer> > adj,
           boolean[] visited, int s, ArrayList<Integer> res)
    {
        visited[s] = true;
        res.add(s);

        // Recursively visit all adjacent vertices that are
        // not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i, res);
            }
        }
    }

    // Main DFS function that initializes the visited array
    // and calls dfsRec
    public static ArrayList<Integer>
    DFS(ArrayList<ArrayList<Integer> > adj)
    {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        dfsRec(adj, visited, 0, res);
        return res;
    }

    // To add an edge in an undirected graph
    public static void
    addEdge(ArrayList<ArrayList<Integer> > adj, int s,
            int t)
    {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void main(String[] args)
    {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        int[][] edges= { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } }; 
        for (int[] e : edges)
        {
            addEdge(adj, e[0], e[1]);
        }

        // Perform DFS starting from vertex 0
        ArrayList<Integer> res = DFS(adj);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
