//public class mergeTwoSortedLinkedList {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     * int val;
//     * ListNode next;
//     * ListNode() {}
//     * ListNode(int val) { this.val = val; }
//     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    // Time Complexity :- O(N+M)
//    // Space Complexity :- O(1)
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
//        ListNode dummyNode = new ListNode(-1);
//        ListNode prev = dummyNode;
//        ListNode currFirst = list1;
//        ListNode currSecond = list2;
//        while (currFirst != null && currSecond != null) {
//            if (currFirst.val <= currSecond.val) {
//                prev.next = currFirst;
//                currFirst = currFirst.next;
//            } else {
//                prev.next = currSecond;
//                currSecond = currSecond.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = currFirst == null ? currSecond : currFirst;
//        return dummyNode.next;
//
//    }
//}
//
