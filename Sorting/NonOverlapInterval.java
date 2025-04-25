import java.util.*;
public class NonOverlapInterval {
    // Java program to minimum number of intervals required 
// to be removed to make remaining intervals non-overlapping
// Using sorting by starting value
    static int minRemoval(int[][] intervals) {
        int cnt = 0;
      
        // Sort by minimum starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            // If the current starting point is less than
            // the previous interval's ending point
            // (ie. there is an overlap)
            if (intervals[i][0] < end) {
              
                // Increase cnt and remove the interval
                // with the higher ending point
                cnt++;
                end = Math.min(intervals[i][1], end);
            }

            // Incase of no overlapping, this interval is 
            // not removed and 'end' will be updated
            else
                end = intervals[i][1];
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals));
    }
}

