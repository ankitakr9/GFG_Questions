// Java program to implement a stack that supports
// all operations in O(1) time and O(1) extra space.

import java.util.Stack;

class DesignStack {
    private Stack<Integer> s;
    private int minEle;

    public DesignStack() {
        s = new Stack<>();
        minEle = -1;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        if (s.isEmpty()) {
            minEle = x;
            s.push(x);
        }
        // If new number is less than minEle
        else if (x < minEle) {
            s.push(2 * x - minEle);
            minEle = x;
        } else {
            s.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();

        // Minimum will change, if the minimum element
        // of the stack is being removed.
        if (top < minEle) {
            minEle = 2 * minEle - top;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (s.isEmpty()) {
            return -1;
        }

        int top = s.peek();

        // If minEle > top means minEle stores value of top.
        return (minEle > top) ? minEle : top;
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (s.isEmpty()) {
            return -1;
        }

        // variable minEle stores the minimum element
        // in the stack.
        return minEle;
    }

    public static void main(String[] args) {
        DesignStack ss = new DesignStack();

        // Function calls
        ss.push(2);
        ss.push(3);
        System.out.print(ss.peek() + " ");
        ss.pop();
        System.out.print(ss.getMin() + " ");
        ss.push(1);
        System.out.print(ss.getMin() + " ");
    }
}