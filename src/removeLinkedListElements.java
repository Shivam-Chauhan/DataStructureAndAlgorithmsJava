public class removeLinkedListElements {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head, currNode = tempNode;
        while (temp != null) {
            if (temp.val != val) {
                currNode.next = temp;
                currNode = currNode.next;
            }
            temp = temp.next;

        }
        currNode.next = null;
        return tempNode.next;
    }
}
