// Java program to find the 
// duplicate element

class onlyRepeating {

    // Function to find the duplicate
    // element in an array
    static int findDuplicate(int[] arr) {

        // slow pointer
        int slow = arr[0]; 

        // fast pointer
        int fast = arr[0]; 

        do {

            // moves one step
            slow = arr[slow];  

            // moves two steps
            fast = arr[arr[fast]];     
        } while (slow != fast);

        // reinitialize fast to the start
        fast = arr[0]; 
  
        // Loop until both pointers meet at the duplicate
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
  
       // Return duplicate number
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4};
        System.out.println(findDuplicate(arr));
    }
}