

class maximumXor {

    // Function to find the maximum XOR
    static int maxXor(int[] arr) {
        int res = 0;

        // Generate all possible pairs
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res = Math.max(res, arr[i] ^ arr[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {26, 100, 25, 13, 4, 14};
        System.out.println(maxXor(arr));
    }
}