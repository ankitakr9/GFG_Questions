import java.util.ArrayList;
import java.util.List;

class SubarraySum {
    // Function to find a continuous sub-array which adds up to
    // a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // Initialize window
        int s = 0, e = 0;  
        ArrayList<Integer> res = new ArrayList<>();

        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            // If current sum becomes more or equal,
            // set end and try adjusting start
            if (curr >= target) {
                e = i;

                // While current sum is greater, 
                // remove starting elements of current window
                while (curr > target && s < e) {
                    curr -= arr[s];
                    ++s;
                }

                // If we found a subarray
                if (curr == target) {
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }
            }
        }
        // If no subarray is found
        res.add(-1);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int target = 23;
        ArrayList<Integer> res = subarraySum(arr, target);

        for (int ele : res)
            System.out.print(ele + " ");
    }
}