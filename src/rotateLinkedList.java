//public class rotateLinkedList {
//    public ListNode rotateLinkedListUtil(ListNode head,int k){
//        if(head==null || head.next==null || k==0) return head;
//        ListNode curr=head;
//        int lengthOfLinkedList=1;
//        while(curr.next!=null){
//            curr=curr.next;
//            lengthOfLinkedList++;
//        }
//        curr.next=head;
//        k=k%lengthOfLinkedList;
//        k=lengthOfLinkedList-k;
//        while(k>0){
//            curr=curr.next;
//            k--;
//        }
//        head=curr.next;
//        curr.next=null;
//        return head;
//    }
//    public static void main(String[] args) {
//
//    }
//}
