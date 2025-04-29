
public class RotatedArraySearch {

    // Function to search key in a sorted and rotated array
    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If key is found
            if (arr[mid] == key) {
                return mid;
            }

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                // Key lies in the left half
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1; // Key not found
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int key = 3;
        int index = search(arr, key);
        if (index != -1) {
            System.out.println("Key found at index: " + index);
        } else {
            System.out.println("Key not found");
        }
    }
}