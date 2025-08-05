class sticklerThief2 {
    static  int maxValue(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        // Case 1: Exclude last house
        int max1 = robLinear(arr, 0, n - 2);
        // Case 2: Exclude first house
        int max2 = robLinear(arr, 1, n - 1);

        return Math.max(max1, max2);
    }

    // Helper function to solve the linear house robber problem
    public static int robLinear(int[] arr, int start, int end) {
        int prev = 0;
        int curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(curr, prev + arr[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
     public static void main(String[] args) {
        int[] arr = {6, 5, 5, 7, 4};
        System.out.println(maxValue(arr));
    }
}
