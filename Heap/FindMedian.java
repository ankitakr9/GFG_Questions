 // Java program to find Median from Running Data Stream
// Using Heaps

import java.util.PriorityQueue;
import java.util.ArrayList;

class FindMedian {
    
    // Function to find the median of a stream of data
    static ArrayList<Double> getMedian(int[] arr) {
        
        // Max heap to store the smaller half of numbers
        PriorityQueue<Integer> leftMaxHeap = new 
          PriorityQueue<>((a, b) -> b - a);
        
        // Min heap to store the greater half of numbers
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        
        ArrayList<Double> res = new ArrayList<>();
      
        for (int i = 0; i < arr.length; i++) {
            
            // Insert new element into max heap
            leftMaxHeap.add(arr[i]);
            
            // Move the top of max heap to min heap to maintain order
            int temp = leftMaxHeap.poll();
            rightMinHeap.add(temp);
          
            // Balance heaps if min heap has more elements
            if (rightMinHeap.size() > leftMaxHeap.size()) {
                temp = rightMinHeap.poll();
                leftMaxHeap.add(temp);
            }
            
            // Compute median based on heap sizes
            double median;
            if (leftMaxHeap.size() != rightMinHeap.size())
                median = leftMaxHeap.peek();
            else
                median = (leftMaxHeap.peek() + 
                          rightMinHeap.peek()) / 2.0;
            
            res.add(median);
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);
        System.out.printf("%.2f", res.get(0));
        
        for (int i = 1; i < res.size(); i++) {
            System.out.printf(" %.2f", res.get(i));
        }
    }
} 
    

