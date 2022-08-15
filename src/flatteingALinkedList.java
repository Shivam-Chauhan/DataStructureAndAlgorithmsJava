//public class flatteingALinkedList {
//    public Node linkedListMerge(Node firstHead,Node secondHead){
//        Node tempHead=new Node(-1);
//        Node result=tempHead;
//        while(firstHead!=null && secondHead!=null){
//            if(firstHead.data<=secondHead.data){
//                tempHead.bottom=firstHead;
//                tempHead=tempHead.bottom;
//                firstHead=firstHead.bottom;
//            }
//            else{
//                tempHead.bottom=secondHead;
//                tempHead=tempHead.bottom;
//                secondHead=secondHead.bottom;
//            }
//        }
//        if(firstHead==null) tempHead.bottom=secondHead;
//        else tempHead.bottom=firstHead;
//
//        return result.bottom;
//    }
//    public Node flattenLinkedList(Node root){
//        if(root==null || root.next==null) return root;
//        root.next=flattenLinkedList(root.next);
//        root=linkedListMerge(root,root.next);
//        return root;
//
//    }
//    public static void main(String[] args) {
//
//    }
//}
