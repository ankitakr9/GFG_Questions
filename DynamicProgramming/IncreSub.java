import java.lang.*;

class increSub{

    // lis() returns the length of the longest
    // increasing subsequence in arr[] of size n
    static int lis(int arr[]) {
        int n = arr.length;
        
        int lis[] = new int[n];
      
        // Initialize LIS values for all indexes
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        // Compute optimized LIS values in
        // bottom up manner
        for (int i = 1; i < n; i++)
            for (int prev = 0; prev < i; prev++)
                if (arr[i] > arr[prev] && lis[i] < lis[prev] + 1)
                    lis[i] = lis[prev] + 1;

        // Pick maximum of all LIS values
        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, lis[i]);

        return max;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lis(arr));
    }
}