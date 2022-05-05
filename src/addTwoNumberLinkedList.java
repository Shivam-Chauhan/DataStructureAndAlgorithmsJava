public class addTwoNumberLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
     // Time Complexity :- O(N)
     // Space Complexity :- O(1)
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummyNode=new ListNode(-1);
         ListNode tempVar=dummyNode;
         ListNode headl1=l1,headl2=l2;
         int carry=0;
         while(headl1!=null || headl2!=null || carry==1){
             int summation=0;
             summation+=headl1!=null? headl1.val:0;
             summation+=headl2!=null? headl2.val:0;
             summation+=carry;
             headl1=headl1!=null? headl1.next:headl1;
             headl2=headl2!=null? headl2.next:headl2;
             tempVar.next=new ListNode(summation%10);
             tempVar=tempVar.next;
             carry=summation/10;
         }
         return dummyNode.next;
     }
}
