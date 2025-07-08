// Java program to find length of the
// longest valid substring

import java.util.Stack;

class LongValidParen {

    // Function to find the length of the 
    // longest valid parentheses substring
    static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();

        // Push -1 as the initial index to
      	// handle the edge case
        stack.push(-1);
        int maxLen = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // If we encounter an opening parenthesis, 
          	// push its index
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                // If we encounter a closing parenthesis, 
              	// pop the stack
                stack.pop();

                // If stack is empty, push the current index 
                // as a base for the next valid substring
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {

                    // Update maxLength with the current length 
                    // of the valid parentheses substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(maxLength(s));
    }
}
