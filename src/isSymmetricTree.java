public class isSymmetricTree {
    // Time Complexity :- O(Max(N+M))
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public boolean isChecker(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot==null && rightRoot==null) return true;
        else if(leftRoot==null || rightRoot==null) return false;
        else if(leftRoot.val==rightRoot.val){
            return isChecker(leftRoot.left,rightRoot.right) && isChecker(leftRoot.right,rightRoot.left);
        }
        return false;
    }
}
