public class isSameTree {
    // Time Complexity :- O(Min(N,M))
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public boolean isSameTreeFinder(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(q==null || p==null) return false;
        if(p.val==q.val && isSameTreeFinder(p.left,q.left) && isSameTreeFinder(p.right, q.right)) return true;
        return false;
    }
}
