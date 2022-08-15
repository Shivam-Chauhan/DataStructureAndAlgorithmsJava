//public class middleOfLinkedList {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    // Time Complexity :- O(N)
//    // Space Complexity :- O(1)
//    public ListNode middleNode(ListNode head) {
//        ListNode fastPointer=head,slowPointer=head;
//        while(fastPointer!=null && fastPointer.next!=null){
//            fastPointer=fastPointer.next.next;
//            slowPointer=slowPointer.next;
//        }
//        return slowPointer;
//    }
//}
