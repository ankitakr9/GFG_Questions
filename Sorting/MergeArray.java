import java.util.Arrays;
public class MergeArray {
    // Java program to merge two sorted arrays a[] and b[] 
// without extra space Using swap and sort

    static void mergeArrays(int[] a, int[] b) {
        int i = a.length - 1, j = 0;

        // Swap smaller elements from b[] with larger elements from a[]
        while (i >= 0 && j < b.length) {
            if (a[i] < b[j])
                i--;
            else {
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
                i--;
                j++;
            }
        }

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}

