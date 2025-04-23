import java.util.Arrays;

class OverlapInterval {

    // Merge overlapping intervals in-place. We return
    // modified size of the array arr.
    static int mergeOverlap(int[][] arr) {

        // Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Index of the last merged 
        int resIdx = 0; 

        for (int i = 1; i < arr.length; i++) {
            
            // If current interval overlaps with the 
            // last merged interval
            if (arr[resIdx][1] >= arr[i][0])           
                arr[resIdx][1] = Math.max(arr[resIdx][1], arr[i][1]);
            
            // Move to the next interval
            else {            
                resIdx++;
                arr[resIdx] = arr[i];
            }
        }

        // Returns size of the merged intervals
        return (resIdx + 1);
    }

    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        
        // Get the new size of the array after merging
        int newSize = mergeOverlap(arr);

        // Print the merged intervals based on the new size
        for (int i = 0; i < newSize; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}