// Java program to find longest sub-array having sum k
// using Hash Map and Prefix Sum

import java.util.HashMap;
import java.util.Map;

class LongestSubarray {
  
  	// Function to find longest sub-array having sum k
    static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];

			// Check if the entire prefix sums to k
            if (prefSum == k) 
                res = i + 1;

            // If prefixSum - k exists in the map then there exist such 
      		// subarray from (index of previous prefix + 1) to i.
            else if (mp.containsKey(prefSum - k)) 
                res = Math.max(res, i - mp.get(prefSum - k));

            // Store only first occurrence index of prefSum
            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }
}