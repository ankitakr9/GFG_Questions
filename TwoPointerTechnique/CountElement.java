// Java program to count distinct elements in every window
// of size k by traversing all windows of size k

import java.util.*;

class CountElement {

    // Function to count distinct elements in every window of size k
    static List<Integer> countDistinct(int[] arr, int k) {
        int n = arr.length;  
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
      
        // Store the frequency of elements of the first window
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
      
        // Store the count of distinct elements of the first window
        res.add(freq.size());
      
        for (int i = k; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            freq.put(arr[i - k], freq.get(arr[i - k]) - 1);
          
            // If the frequency of arr[i - k] becomes 0, 
            // remove it from the hash map
            if (freq.get(arr[i - k]) == 0) {
                freq.remove(arr[i - k]);
            }
          
            res.add(freq.size());
        }
      
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        List<Integer> res = countDistinct(arr, k);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}