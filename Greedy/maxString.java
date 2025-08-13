// Java program to split the string
import java.util.HashMap;

public class maxString{

    // Function to find the maximum number of substrings
    // such that there is no common character between them
    public static int maxPartitions(String s) {

        // HashMap to store the last occurrence
        // of each character in the string
        int[] last = new int[26];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }

        // Traverse the string to record
        // the last position of each character
        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        // count the number of partitions
        int cnt = 0;

        // To track the farthest last occurrence seen
        int a = -1;

        for (int i = 0; i < s.length(); i++) {
            a = Math.max(last[s.charAt(i) - 'a'], a);

            // If the current index matches the
            // farthest occurrence, form a partition
            if (a == i)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        String s = "acbbcc";
        System.out.println(maxPartitions(s));
    }
}