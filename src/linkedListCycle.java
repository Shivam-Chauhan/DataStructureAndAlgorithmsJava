//public class linkedListCycle {
//    // Time Complexity :- O(2*M)
//    // Space Complexity :- O(1)
//    public boolean hasCycle(ListNode head) {
//        ListNode slowPointer=head,fastPointer=head;
//        while(fastPointer!=null && fastPointer.next!=null){
//            slowPointer=slowPointer.next;
//            fastPointer=fastPointer.next.next;
//            if(slowPointer==fastPointer) return true;
//        }
//        return false;
//    }
//}
