// Java program to solve job sequencing
// problem with maximum profit
import java.util.*;

public class jobSequence {
    
     static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        
        // Pair the profit and deadline of all the jobs together
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }

        // Sort the jobs based on deadline in ascending order
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        
        // Min-heap to maintain the scheduled jobs based on profit
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] job : jobs) {
            
            // If job can be scheduled within its deadline
            if (job[0] > pq.size()) {
                pq.add(job[1]);
            } 
            
            // Replace the job with the lowest profit
            else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }

        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25,15};
        ArrayList<Integer> result = jobSequencing(deadline, profit);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}