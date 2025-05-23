// Java program for counting pairs with given sum 
// using Two Pointer Technique

import java.util.Arrays;

class TwoSumCountPairs {

    // Function to return the count of pairs
    static int countPairs(int[] arr, int target) {
        int res = 0;
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
          
            // If sum is greater 
            if (arr[left] + arr[right] < target)
                left++;

            // If sum is lesser
            else if (arr[left] + arr[right] > target)
                right--;

            // If sum is equal
            else {
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];
              
                // Count frequency of first element of the pair
                while (left <= right && arr[left] == ele1) {
                    left++;
                    cnt1++;
                }
              
                // Count frequency of second element of the pair
                while (left <= right && arr[right] == ele2) {
                    right--;
                    cnt2++;
                }
               
                // If both the elements are same, then count of
                // pairs = the number of ways to choose 2 
                // elements among cnt1 elements
                if (ele1 == ele2) 
                    res += (cnt1 * (cnt1 - 1)) / 2;
              
                // If the elements are different, then count of
                // pairs = product of the count of both elements
                else 
                    res += (cnt1 * cnt2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 5, 5, 7};
        int target = 6;

        System.out.println(countPairs(arr, target));
    }
}