public class deleteNthNodeFromLast {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode fastPointer=dummy;
        ListNode slowPointer=dummy;
        for(int i=0;i<n;i++){
            fastPointer=fastPointer.next;
        }
        while(fastPointer.next!=null){
            fastPointer=fastPointer.next;
            slowPointer=slowPointer.next;
        }
        slowPointer.next=slowPointer.next.next;
        return start.next;
    }
}
