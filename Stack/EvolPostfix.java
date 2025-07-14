// Java program to evaluate value of a postfix
// expression Using Stack
import java.util.Stack;

 class EvolPostfix {
    
    // Function to evaluate postfix expression
    static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {
            
            // If the token is a number, push it onto the stack
            if (token.matches("-?\\d+")) {  
                stack.push(Integer.parseInt(token));
            } 
            
            // Otherwise, it must be an operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "/":
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr)); 
    }
}