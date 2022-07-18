public class detectLoopLL {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public static boolean detectLoop(Node head){
        if(head==null) return false;
        Node slowPointer=head, fastPointer=head;
        while(fastPointer.next!=null && fastPointer.next.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
            if(fastPointer==slowPointer) return true;
        }
        return false;
    }
}
