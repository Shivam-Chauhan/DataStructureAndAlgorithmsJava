public class removeDuplicatesFromSortedLL {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = head;
        while (tempHead != null) {
            if (tempHead.next != null && tempHead.val == tempHead.next.val) {
                tempHead.next = tempHead.next.next;
            } else {
                tempHead = tempHead.next;
            }
        }
        return head;
    }
}
