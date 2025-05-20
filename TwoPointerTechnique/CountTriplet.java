// Java program to count all triplets having sum equal to
// target by exploring all possible triplets

import java.util.*;
class CountTriplet {

    // Function to count triplets whose sum equals the target
    static int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int res = 0;

        // Iterate through each element as the first element
        // of the triplet
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            // Use two-pointer approach to find triplets
            while (left < right) {

                // Calculate the sum of the triplet
                int sum = arr[i] + arr[left] + arr[right];

                // If sum is smaller, move to bigger values
                if (sum < target) {
                    left += 1;
                }
                
                // If sum is greater, move to smaller values
                else if (sum > target) {
                    right -= 1;
                }
                
                // If sum is equal, check for frequency of elements
                else if (sum == target) {
                    int ele1 = arr[left], ele2 = arr[right];
                    int cnt1 = 0, cnt2 = 0;

                    // Count frequency of the current value at 'left'
                    while (left <= right && arr[left] == ele1) {
                        left++;
                        cnt1++;
                    }

                    // Count frequency of the current value at 'right'
                    while (left <= right && arr[right] == ele2) {
                        right--;
                        cnt2++;
                    }

                    // If both the elements are the same, then count 
                    // of pairs = the number of ways to choose 2 
                    // elements among cnt1 elements
                    if (ele1 == ele2)
                        res += (cnt1 * (cnt1 - 1)) / 2;

                    // If the elements are different, then count of  
                    // pairs = product of the count of both elements
                    else
                        res += (cnt1 * cnt2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, -1, 0, 1, 2};
        int target = -2;

        System.out.println(countTriplets(arr, target));
    }
} 
    

