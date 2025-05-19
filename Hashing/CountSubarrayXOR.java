// Java Program to count all subarrays having
// XOR of elements as given value K using Hash Map
import java.util.HashMap;

class CountSubarrayXOR {
    // Function to find the count of subarrays of arr
    // with XOR value equals to k
    static int subarrayXor(int[] arr, int k) {
        int res = 0;

        // Create map that stores number of prefix arrays
        // corresponding to a XOR value
        HashMap<Integer, Integer> mp = new HashMap<>();

        int prefXOR = 0;

        for (int val : arr) {
          
            // Find XOR of current prefix
            prefXOR ^= val;

            // If prefXOR ^ k exists in mp then there is a subarray
            // ending at i with XOR equal to k
            res += mp.getOrDefault(prefXOR ^ k, 0);

            // If this prefix subarray has XOR equal to k
            if (prefXOR == k)
                res++;

            // Add the XOR of this subarray to the map
            mp.put(prefXOR, mp.getOrDefault(prefXOR, 0) + 1);
        }

        // Return total count of subarrays having XOR of
        // elements as given value k
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(subarrayXor(arr, k));
    }
}