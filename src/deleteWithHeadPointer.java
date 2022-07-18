public class deleteWithHeadPointer {
    // Time Complexity :- O(1)
    // Space Complexity :- O(1)
    void deleteNode(Node del)
    {
        del.data=del.next.data;
        del.next=del.next.next;
    }
}
