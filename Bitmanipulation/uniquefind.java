import java.util.List;
import java.util.Arrays;

public class uniquefind {
    public static int findUnique(int[] arr) {
        int res = 0;

        // Find XOR of all elements
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};
        System.out.println(findUnique(arr));
    }
}