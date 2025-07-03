// Java program to find the k largest elements in the  
// array using min heap
import java.util.*;

class FindKLargest {
    
    // Function to find the k largest elements in the array 
    static ArrayList<Integer> kLargest(int[] arr, int k) {
        
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Traverse the rest of the array
        for (int i = k; i < arr.length; i++) {
          
            // If current element is larger than 
            // the smallest in heap
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Extract elements from the heap
        ArrayList<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        // Reverse the list for descending order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2009, 12, 9, 30, 200, 509};
        int k = 3;

        ArrayList<Integer> res = kLargest(arr, k);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}