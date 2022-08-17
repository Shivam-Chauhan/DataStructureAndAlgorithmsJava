public class sortLL {
    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // Link :- https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
    static Node middleOfLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeTwoLL(Node head1, Node head2) {
        if (head1 == null || head2 == null) return head1 == null ? head2 : head1;
        Node tempHead1 = head1, tempHead2 = head2;
        Node newNode = new Node(0);
        Node copy = newNode;
        while (tempHead1 != null && tempHead2 != null) {
            if (tempHead1.data <= tempHead2.data) {
                copy.next = tempHead1;
                tempHead1 = tempHead1.next;
            } else {
                copy.next = tempHead2;
                tempHead2 = tempHead2.next;
            }
            copy = copy.next;
        }

        copy.next = tempHead1 == null ? tempHead2 : tempHead1;
        return newNode.next;

    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node middleNode = middleOfLinkedList(head);
        Node newHead = middleNode.next;
        middleNode.next = null;
        Node n1 = mergeSort(head);
        Node n2 = mergeSort(newHead);
        return mergeTwoLL(n1, n2);
    }
}
