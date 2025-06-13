class ReverseKGroup {

    // Definition for singly-linked list.
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    // Function to reverse every group of k nodes
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrev = dummy;

        while (true) {
            Node kth = getKthNode(groupPrev, k);
            if (kth == null) break;

            Node groupNext = kth.next;
            // Reverse group
            Node prev = groupNext, curr = groupPrev.next;

            while (curr != groupNext) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            Node temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    // Helper function to get the kth node from the current node
    private static Node getKthNode(Node curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Function to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Sample test
    public static void main(String[] args) {
        // Creating list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        int k = 3;

        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("Reversed List in Groups of " + k + ":");
        printList(head);
    }
}