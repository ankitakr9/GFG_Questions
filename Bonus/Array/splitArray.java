// Java program to find if the array can be divided into
// three segments by finding first two segments

import java.util.Arrays;

class splitArray
 {

    static int[] findSplit(int[] arr) {
        int[] res = new int[2];
        int n = arr.length;
        int resIdx = 0;
        int total = 0;

        for (int i = 0; i < n; i++)
            total += arr[i];

        // If the total sum is not divisible by 3,
        // it's impossible to split the array
        if (total % 3 != 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        // Keep track of the sum of current segment
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            // If the valid segment is found, store its index
            // and reset current sum to zero
            if (currSum == total / 3) {
                currSum = 0;
                res[resIdx++] = i;

                // If two valid segments are found and third non
                // empty segment is possible, return true
                if (resIdx == 2 && i < n - 1) {
                    return res;
                }
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 4};
        int[] res = findSplit(arr);

        System.out.println(res[0] + " " + res[1]);
    }
}