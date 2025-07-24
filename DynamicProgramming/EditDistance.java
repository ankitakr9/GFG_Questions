// Java program to find minimum number
// of operations to convert s1 to s2
import java.util.*;

class EditDistance {

    // Function to find the minimum number 
    // of operations to convert s1 to s2
    static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Stores dp[i-1][j-1]
        int prev;
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) 
            curr[j] = j;

        for (int i = 1; i <= m; i++) {
            prev = curr[0];
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = curr[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = prev;
                else
                    curr[j] = 1 + Math.min(Math.min(curr[j - 1], 
                                                     prev), curr[j]);
                prev = temp;
            }
        }

        return curr[n];
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcfe";

        System.out.println(editDistance(s1, s2));
    }
}