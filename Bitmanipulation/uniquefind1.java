import java.util.Arrays;
import java.util.List;

public class uniquefind1 {
    public static int[] singleNum(int[] arr) {
        
        // Get the XOR of the two numbers we need to find
        int xorVal = 0;
        for (int i : arr) {
            xorVal ^= i;
        }

        // Get its last set bit
        xorVal &= -xorVal;

        int[] res = new int[2];
        
        for (int num : arr) {
            
            // If bit is not set, it belongs to the first set
            if ((num & xorVal) == 0) { 
                res[0] ^= num;
            }
            
            // If bit is set, it belongs to the second set
            else { 
                res[1] ^= num;
            }
        }

        // Ensure the order of the returned numbers is consistent
        if (res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1, 4 };
        int[] ans = singleNum(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }
}