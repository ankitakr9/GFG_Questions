import java.util.Stack;

class TrappingWater {

    static int maxWater(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
           
            // Pop all items smaller than arr[i]
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {          
                
                int pop_height = arr[st.pop()];

                if (st.isEmpty())
                    break;

                // arr[i] is the next greater for the removed item
                // and new stack top is the previous greater 
                int distance = i - st.peek() - 1;

                // Take the minimum of two heights (next and prev greater)
                int water = Math.min(arr[st.peek()], arr[i]);

                // Find the amount of water
                water -= pop_height;
                
                res += distance * water;
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 1, 0, 4};
        System.out.println(maxWater(arr));
    }
}
