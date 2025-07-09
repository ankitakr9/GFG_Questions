// Java implementation to find the next
// greater element using a stack
import java.util.ArrayList;
import java.util.Stack;

class NGE {

    static ArrayList<Integer> nextLargerElement(int[] arr) {

        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();

        // Initialize res with -1 for all elements
        for (int i = 0; i < n; i++) {
            res.add(-1);
        }

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from the stack that are less
            // than or equal to the current element
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }

            // If the stack is not empty, the top element
            // is the next greater element
            if (!stk.isEmpty()) {
                res.set(i, stk.peek());
            }

            // Push the current element onto the stack
            stk.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        ArrayList<Integer> res = nextLargerElement(arr);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}