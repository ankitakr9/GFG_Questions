// Java program to rotate a linked list
// by changing pointer of kth node

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Function to rotate the linked list
// to the left by k places
class RotateLinkedList {
    static Node rotate(Node head, int k) {

        // If the linked list is empty or no rotations are
        // needed, then return the original linked list
        if (k == 0 || head == null)
            return head;

        Node curr = head;
        int len = 1;
      
        // Find the length of linked list
        while (curr.next != null) {
            curr = curr.next;
            len += 1;
        }

        // Modulo k with length of linked list to handle
        // large values of k
        k %= len;
      
        if (k == 0)
            return head;
      
      	// Make the linked list circular
        curr.next = head;

        // Traverse the linked list to find the kth node
        curr = head;
        for (int i = 1; i < k; i++)
            curr = curr.next;

        // Update the (k + 1)th node as the new head
        head = curr.next;
      
        // Break the loop by updating next pointer of kth node
        curr.next = null;
        return head;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
      
        head = rotate(head, 6);
        printList(head);
    }
}