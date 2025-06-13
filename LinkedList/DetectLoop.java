// Java program to detect loop in a linked list
// using Floyd's Cycle-Finding Algorithm

class Node {
    int data;
    Node next;

    public Node(int x) {
        this.data = x;
        this.next = null;
    }
}

class DetectLoop {
    static boolean detectLoop(Node head) {
  
        // Fast and slow pointers initially points to the head
        Node slow = head, fast = head;

        // Loop that runs while fast and slow pointer are not
        // null and not equal
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast and slow pointer points to the same node,
            // then the cycle is detected
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
  
        // Create a loop
        head.next.next.next = head.next;

        if (detectLoop(head))
            System.out.println("true");
        else
            System.out.println("false");
    }
}