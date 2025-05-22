// Java Program to find pair with sum closest to target 
// using Two Pointer Technique

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SumPair {
    
    // function to return the pair with sum closest to target
    static List<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];

            // Check if this pair is closer than the closest
            // pair so far
            if (Math.abs(target - currSum) < minDiff) {
                minDiff = Math.abs(target - currSum);
                res = Arrays.asList(arr[left], arr[right]);
            }

            // If this pair has less sum, move to greater values
            if (currSum < target)
                left++;

            // If this pair has more sum, move to smaller values
            else if (currSum > target)
                right--;

            // If this pair has sum = target, return it
            else
                return res;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 1, 4};
        int target = 10;

        List<Integer> res = sumClosest(arr, target);
        if(res.size() > 0)
        	System.out.println(res.get(0) + " " + res.get(1));
    }
}