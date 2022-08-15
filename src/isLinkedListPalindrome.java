//// Time Complexity :- O(N)
//// Space Complexity :- O(1)
//public class isLinkedListPalindrome {
//
//    public ListNode middleOfLinkedList(ListNode head){
//        ListNode fastPointer=head,slowPointer=head;
//        while(fastPointer.next!=null && fastPointer.next.next!=null){
//            fastPointer=fastPointer.next.next;
//            slowPointer=slowPointer.next;
//        }
//        return slowPointer;
//    }
//    public ListNode reverseOfLinkedList(ListNode head){
//        ListNode currPointer=head,prevPointer=null;
//        while(currPointer!=null){
//            ListNode nextPointer=currPointer.next;
//            currPointer.next=prevPointer;
//            prevPointer=currPointer;
//            currPointer=nextPointer;
//        }
//        return prevPointer;
//    }
//    public boolean checkIfPalindrome(ListNode tempOldHead,ListNode tempNewHead){
//        while(tempNewHead!=null && tempOldHead!=null){
//            if(tempNewHead.val!=tempOldHead.val) return false;
//            tempNewHead=tempNewHead.next;
//            tempOldHead=tempOldHead.next;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        isLinkedListPalindrome obj=new isLinkedListPalindrome();
//        ListNode middleNode=obj.middleOfLinkedList(head);
//        ListNode newHead=middleNode.next;
//        middleNode.next=null;
//        ListNode reverseHead=obj.reverseOfLinkedList(newHead);
//        ListNode tempHeadOld=head,tempHeadNew=reverseHead;
//    }
//
//}
