class stockBuySell {
    
    static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[][] curr = new int[3][2];
        int[][] next = new int[3][2];

        // Iterate from the last day to the first
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 2; k++) {
                
                // Calculate for buy state
                curr[k][1] = Math.max(-prices[i] + next[k][0], next[k][1]);

                // Calculate for sell state
                curr[k][0] = Math.max(prices[i] + next[k - 1][1], next[k][0]);
            }
            
            // Move current state to next, for the
            // next iteration
            next = curr.clone();
        }

        return curr[2][1];
    }

    public static void main(String[] args) {
        int[] prices = {10, 39, 5, 75, 65, 80};
        System.out.println(maxProfit(prices));
    }
}