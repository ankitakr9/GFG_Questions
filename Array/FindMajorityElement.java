package Array;
 // Java program for finding out majority element in an array
// using hash map
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class FindMajorityElement {
   
    
    // Function to find Majority element in an array
    static List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        // find frequency of each number
        for (int ele : arr)
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
      
        // Iterate over each key-value pair in the hash map
        for (Map.Entry<Integer, Integer> it : freq.entrySet()) {
            int ele = it.getKey();
            int cnt = it.getValue();
          
            // Add the element to the result, if its frequency
        	// if greater than floor(n/3)
            if (cnt > n / 3)
                res.add(ele);
        }
      
        if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};
        List<Integer> res = findMajority(arr);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}

