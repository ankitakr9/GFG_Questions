import java.util.*;

public class disconnectGraph {

    // dfs function to visit nodes
    static void dfs(List<Integer>[] adj, int c,
                    boolean[] visited) {
        visited[c] = true;
        for (int neighbor : adj[c]) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }

    // Build adjacency list from edge list, excluding edge
    // (c, d)
    static List<Integer>[] constructAdj(int V,
                                        int[][] edges,
                                        int c, int d) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if ((a == c && b == d) || (a == d && b == c))
                continue;

            adj[a].add(b);
            adj[b].add(a);
        }
        return adj;
    }

    static boolean isBridge(int V, int[][] edges, int c,
                            int d) {
        List<Integer>[] adj = constructAdj(V, edges, c, d);
        boolean[] visited = new boolean[V];
        dfs(adj, c, visited);
        
        // if d not reachable from c →
        // edge (c, d) is a bridge
        return !visited[d]; 
    }

   public static void main(String[] args)
    {
        int V = 4;
        int[][] edges = {{ 0, 1 }, { 1, 2 }, { 2,3 }};
        int c = 1, d = 2;
        System.out.println(
            isBridge(V, edges, c, d) ? "true" : "false");
    }
}