public class copyLLWithRandomPtr {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
    public Node copyRandomList(Node head) {
        // Step 1 :- Add Elements In Front Of LL
        Node itr = head;
        while (itr != null) {
            Node front = itr.next;
            Node newNode = new Node(itr.val);
            itr.next = newNode;
            newNode.next = front;
            itr = front;
        }
        // Step 2 :- Attach Random Ptr To The Clone LinkedList
        itr = head;
        while (itr != null) {
            if (itr.random != null)
                itr.next.random = itr.random.next;
            itr = itr.next.next;
        }

        // Step 3 :- Detach The Clone LinkedList From The Original One..
        Node newCopy = new Node(0);
        Node copy = newCopy;
        itr = head;
        while (itr != null) {
            Node front = itr.next.next;
            copy.next = itr.next;
            copy = copy.next;
            itr.next = front;
            itr = front;
        }
        return newCopy.next;
    }
}
