// Java program to merge K sorted linked lists
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class MergeK {

    // Function to merge two sorted lists.
    static Node mergeTwo(Node head1, Node head2) {

        // Create a dummy node to simplify 
        // the merging process
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Iterate through both linked lists
        while (head1 != null && head2 != null) {

            // Add the smaller node to the merged list
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        // If any list is left, append it to
        // the merged list
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        // Return the merged list starting
        // from the next of dummy node
        return dummy.next;
    }

    static Node mergeListsRecur(int i, int j, List<Node> arr) {

        // If single list is left
        if (i == j) return arr.get(i);

        // Find the middle of lists
        int mid = i + (j - i) / 2;

        // Merge lists from i to mid 
        Node head1 = mergeListsRecur(i, mid, arr);

        // Merge lists from mid+1 to j 
        Node head2 = mergeListsRecur(mid + 1, j, arr);

        // Merge the above 2 lists 
        Node head = mergeTwo(head1, head2);

        return head;
    }

    // Function to merge K sorted linked lists
    static Node mergeKLists(List<Node> arr) {

        // Base case for 0 lists 
        if (arr.size() == 0) return null;

        return mergeListsRecur(0, arr.size() - 1, arr);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3;

        List<Node> arr = new java.util.ArrayList<>();

        arr.add(new Node(1));
        arr.get(0).next = new Node(3);
        arr.get(0).next.next = new Node(5);
        arr.get(0).next.next.next = new Node(7);

        arr.add(new Node(2));
        arr.get(1).next = new Node(4);
        arr.get(1).next.next = new Node(6);
        arr.get(1).next.next.next = new Node(8);

        arr.add(new Node(0));
        arr.get(2).next = new Node(9);
        arr.get(2).next.next = new Node(10);
        arr.get(2).next.next.next = new Node(11);

        Node head = mergeKLists(arr);

        printList(head);
    }
}