public class intersectionOfList {
    // Time Complexity :- O(2*N)
    // Space Complexity :- O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempHeadA=headA,tempHeadB=headB;
        while(tempHeadA!=tempHeadB){
            tempHeadA=tempHeadA==null?headA:tempHeadA.next;
            tempHeadB=tempHeadB==null?headB:tempHeadB.next;
        }
        return tempHeadA;
    }
}
