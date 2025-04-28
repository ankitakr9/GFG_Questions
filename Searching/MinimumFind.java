// Java program to find minimum element in a 
// sorted rotated array using linear search

import java.util.*;

class MinimumFind {
    static int findMin(int[] arr) {
        int res = arr[0];

        // Traverse over arr[] to find minimum element
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}