class NodeN{
    int val;
    NodeN left, right,next;
    NodeN(int val){
        this.val=val;
        this.left=null;
        this.right=null;
        this.next=null;
    }
}
public class populatingNextPtrBTree {
    // Time Complexity :- ~ O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public NodeN connector(NodeN root){
        if(root==null) return null;
        NodeN leftNode=root.left, rightNode=root.right, nextNode=root.next;
        if(leftNode!=null){
            leftNode.next=rightNode;
            if(nextNode!=null){
                rightNode.next=nextNode.left;
            }
            connector(leftNode);
            connector(rightNode);
        }

        return root;
    }
    public NodeN connect(NodeN root) {
        return connector(root);
    }
}
