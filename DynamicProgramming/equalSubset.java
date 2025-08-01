// Java program to partition a Set 
// into Two Subsets of Equal Sum
// using space optimised
class equalSubset {

    static boolean equalPartition(int[] arr) {
        
        // Calculate sum of the elements in array 
        int sum = 0; 
        for (int num : arr) {
            sum += num;
        }
        
        // If sum is odd, there cannot be two 
        // subsets with equal sum 
        if (sum % 2 != 0)
            return false;

        sum = sum / 2;

        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        // Mark prev[0] = true as it is true
        // to make sum = 0 using 0 elements
        prev[0] = true;

        // Fill the subset table in
        // bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1])
                    curr[j] = prev[j];
                else
                    curr[j] = (prev[j] || prev[j - arr[i - 1]]);
            }
            
            // copy curr into prev 
            for (int j=0; j<=sum; j++) {
                prev[j] = curr[j];
            }
        }
        return prev[sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        if (equalPartition(arr)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}