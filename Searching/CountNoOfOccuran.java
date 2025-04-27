// Java program to find the occurrence of given
// target using linear search

class CountNoOfOccuran {
    static int countFreq(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
          
            // If the current element is equal to 
            // target, increment the result
            if (arr[i] == target)
                res++;
        }
      
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;
        System.out.println(countFreq(arr, target));
    }
}


