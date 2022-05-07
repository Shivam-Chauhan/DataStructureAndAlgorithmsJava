// Time Complexity :- O(N)
// Space Complexity :- O(1)
public class startingOfCycleInLinkedList {
    public ListNode findingStartingNodeOfCycle(ListNode head){
        ListNode fastPointer=head,slowPointer=head;
        while(fastPointer.next!=null && fastPointer.next.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if(slowPointer==fastPointer){
                slowPointer=head;
                while(slowPointer!=fastPointer){
                    slowPointer=slowPointer.next;
                    fastPointer=fastPointer.next;
                }
                return slowPointer;
            }
        }
        return null;
    }
}
