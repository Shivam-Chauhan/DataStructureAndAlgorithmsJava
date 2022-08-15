//public class mergeKSortedList {
//    // Time Complexity :- O(N*K*Log(K))
//    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
//    public ListNode mergeLinkedList(ListNode node1, ListNode node2){
//        if(node1==null || node2==null) return node1==null?node2:node1;
//
//        ListNode tempNode=new ListNode(0);
//        ListNode curr=tempNode;
//        while(node1!=null && node2!=null){
//            if(node1.val<=node2.val){
//                curr.next=node1;
//                node1=node1.next;
//            }
//            else{
//                curr.next=node2;
//                node2=node2.next;
//            }
//            curr=curr.next;
//        }
//        if(node1!=null) curr.next=node1;
//        if(node2!=null) curr.next=node2;
//
//        return tempNode.next;
//    }
//    public ListNode mergerFunction(ListNode[] list1, int start, int end){
//        if(start>end) return null;
//        if(start==end) return list1[start];
//        int middle=(start+end)/2;
//        ListNode leftSide=mergerFunction(list1,start, middle);
//        ListNode rightSide=mergerFunction(list1, middle+1, end);
//        return mergeLinkedList(leftSide, rightSide);
//    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        return mergerFunction(lists, 0, lists.length-1);
//    }
//}
