//public class LinkedList {
//    Node head;
//    static class Node{
//        int data;
//        Node next;
//        Node(int d){
//            data=d;
//        }
//    }
//
//    public static LinkedList insert(LinkedList list,int data){
//        Node newNode=new Node(data);
//        newNode.next=null;
//        if(list.head==null){
//            list.head=newNode;
//        }
//        else{
//            Node last=list.head;
//            while(last.next!=null){
//                last=last.next;
//            }
//            last.next=newNode;
//        }
//        return list;
//    }
//    public static void printLinkedList(LinkedList list){
//        Node currNode=list.head;
//        while(currNode!=null){
//            System.out.println(currNode.data);
//            currNode=currNode.next;
//        }
//    }
//    public static void main(String[] args) {
//        LinkedList list=new LinkedList();
//        list=insert(list,1);
//        list=insert(list,1);
//        list=insert(list,1);
//        list=insert(list,1);
//        list=insert(list,1);
//        list=insert(list,1);
//        list=insert(list,1);
//        list=insert(list,1);
//        printLinkedList(list);
//
//    }
//
//}
