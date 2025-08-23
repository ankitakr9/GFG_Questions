import java.util.*;

 class minimumCost {

    // Calculates Max Distance between two houses
    static int maxDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    // Returns the minimum cost to connect 
    // all houses using Prim's algorithm
    static int minCost(int[][] houses) {
        int n = houses.length;

        // Min-heap to store {cost, houseIndex}
        PriorityQueue<int[]> minHeap = 
        new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Marks whether a house is already connected
        boolean[] visited = new boolean[n];

        // Start with the first house (index 0)
        minHeap.offer(new int[]{0, 0});

        int totalCost = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int u = curr[1];

            // Skip if already connected
            if (visited[u]) continue;

            // Mark as connected and add the cost
            visited[u] = true;
            totalCost += cost;

            // Add distances to all unvisited houses
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = maxDistance(houses[u],
                                                 houses[v]);
                    minHeap.offer(new int[]{dist, v});
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] houses = {
            {0, 7}, {0, 9}, {20, 7}, {30, 7}, {40, 70}
        };

        int result = minCost(houses);
        System.out.println(result);
    }
}