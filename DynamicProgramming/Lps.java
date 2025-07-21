// Java program to find longest
// palindromic subsequence 
import java.util.*;

// Java program to find the length of the lps
class Lps {

  // Function to find the length of the lps
  static int longestPalinSubseq(String s) {
    int n = s.length();

    // Create two arrays: one for the current state (dp)
    // and one for the previous state (dpPrev)
    int[] curr = new int[n];
    int[] prev = new int[n];

    // Loop through the string in reverse (starting from the end)
    for (int i = n - 1; i >= 0; --i) {

      // Initialize the current state of dp
      curr[i] = 1;

      // Loop through the characters ahead of i
      for (int j = i + 1; j < n; ++j) {

        // If the characters at i and j are the same
        if (s.charAt(i) == s.charAt(j)) {

          // Add 2 to the length of the palindrome between them
          curr[j] = prev[j - 1] + 2;
        } else {

          // Take the maximum between excluding either i or j
          curr[j] = Math.max(prev[j], curr[j - 1]);
        }
      }

      // Update previous to the current state of dp
      prev = curr.clone();
    }

    return curr[n - 1];
  }

  public static void main(String[] args) {
    String s = "bbabcbcab";
    System.out.println(longestPalinSubseq(s));
  }
}