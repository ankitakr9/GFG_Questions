// Java program to find starting index of circular Tour
// using greedy approach in one pass

class gasStation{
    static int startStation(int[] gas, int[] cost) {
        int n = gas.length;

        // Variables to track total and current remaining gas
        int totalGas = 0;
        int currGas = 0;
        int startIdx = 0;

        // Traverse through each station to calculate remaining
        // gas in the tank, and total gas
        for (int i = 0; i < n; i++) {
            currGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            // If currGas is negative, circular tour can't
            // start with this index, so update it to next one
            if (currGas < 0) {
                currGas = 0;
                startIdx = i + 1;
            }
        }

        // No solution exists
        if (totalGas < 0)
            return -1;

        return startIdx;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(startStation(gas, cost));
    }
}