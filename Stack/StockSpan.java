// Java program to calculate stock span 
// values using a stack
import java.util.*;

class StockSpan {

    // Function to calculate stock span values
    static ArrayList<Integer> calculateSpan(int[] arr) {

        int n = arr.length; 
        ArrayList<Integer> span = new ArrayList<>(
                              Collections.nCopies(n, 0));  
        Stack<Integer> stk = new Stack<>();  

        // Process each day's price
        for (int i = 0; i < n; i++) {

            // Remove elements from the stack while the current price 
            // is greater than or equal to stack's top price
            while (!stk.isEmpty() && arr[stk.peek()] <=
                                        arr[i]) {
                stk.pop();
            }

            // If stack is empty, all elements to the left are smaller
            // Else, top of the stack is the last greater element's index
            if (stk.isEmpty()) {
                span.set(i, (i + 1));
            } else {
                span.set(i, (i - stk.peek()));
            }

            // Push the current index to the stack
            stk.push(i);
        }

        return span;
    }
  
    public static void main(String[] args) {

        int[] arr = {10, 4, 5, 90, 120, 80};

        ArrayList<Integer> span = calculateSpan(arr);

        for (int x : span) {
            System.out.print(x + " ");
        }
    }
}