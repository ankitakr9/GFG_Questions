// Java program to find K-th Element of Merged Two Sorted Arrays
// using Binary Search

import java.util.*;
class FindKthPosition {
    static int kthElement(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;

        // If a[] has more elements, then call kthElement
        // with reversed parameters
        if (n > m)
            return kthElement(b, a, k);

        // Binary Search on the number of elements we can
        // include in the first set from a[]
        int lo = Math.max(0, k - m), hi = Math.min(k, n);

        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            // Find elements to the left and right of partition in a[]
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : 
                      					a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : 
                      						a[mid1]);

            // Find elements to the left and right of partition in a[]
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : 
                      					b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE :
                      						b[mid2]);

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1) {
                // Find and return the maximum of l1 and l2
                return Math.max(l1, l2);
            }

            // Check if we need to take lesser elements from a[]
            if (l1 > r2)
                hi = mid1 - 1;

            // Check if we need to take more elements from a[]
            else
                lo = mid1 + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;

        System.out.println(kthElement(a, b, k));
    }
}