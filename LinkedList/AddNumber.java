// Java Program to add two number represented as
// linked list by storing sum on the longer list

class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class AddNumber {

    // Function to reverse the linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to find the length of linked list
    static int countNodes(Node head) {
        int len = 0;
        Node curr = head;

        while (curr != null) {
            len += 1;
            curr = curr.next;
        }
        return len;
    }

	// function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }
  
    // Function to add two numbers represented by linked list
    static Node addTwoLists(Node num1, Node num2) {
		num1 = trimLeadingZeros(num1);
		num2 = trimLeadingZeros(num2);
      
        // Find the length of both the linked lists
        int len1 = countNodes(num1);
        int len2 = countNodes(num2);

        // If num1 is smaller, swap the two linked lists by
        // calling the function with reversed parameters
        if (len1 < len2) {
            return addTwoLists(num2, num1);
        }

        int carry = 0;
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node res = num1;

        // Iterate till either num2 is not empty or
        // carry is greater than 0
        while (num2 != null || carry != 0) {

            // Add carry to num1
            num1.data += carry;

            // If num2 linked list is not empty, add it to num1
            if (num2 != null) {
                num1.data += num2.data;
                num2 = num2.next;
            }

            // Store the carry for the next nodes
            carry = num1.data / 10;

            // Store the remainder in num1
            num1.data = num1.data % 10;

            // If we are at the last node of num1 but carry is
            // still left, then append a new node to num1
            if (num1.next == null && carry != 0) {
                num1.next = new Node(0);
            }

            num1 = num1.next;
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverse(res);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
      	// Creating first linked list: 1 -> 2 -> 3
        // (represents 123)
        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        // Creating second linked list: 9 -> 9 -> 9
        // (represents 999)
        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);

        Node sum = addTwoLists(num1, num2);
        printList(sum);
    }
}
