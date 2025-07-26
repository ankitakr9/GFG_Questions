// Java program to count number of
// ways to reach nth stair.
import java.util.*;

class minCost {

    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        if (n == 1) return cost[0];
        
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // Return minimum of cost to  
        // climb (n-1)th stair and  
        // cost to reach (n-2)th stair
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = { 16, 19, 10, 12, 18 };
        System.out.println(minCostClimbingStairs(cost));
    }
}
