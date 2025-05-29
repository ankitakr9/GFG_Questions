// Java Program to find the maximum amount of water in the 
// container using Two Pointer Technique

import java.util.*;

class ContainWater {
    static int maxWater(int[] arr) {
        int left = 0, right = arr.length - 1;
        int res = 0;
        while (left < right) {
            
            // Find the water stored in the container between 
            // arr[left] and arr[right]
            int water = Math.min(arr[left], arr[right]) 
              * (right - left);
            res = Math.max(res, water);
            
            if (arr[left] < arr[right])
                left += 1;
            else
                right -= 1;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWater(arr));
    }
}
