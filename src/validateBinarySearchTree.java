public class validateBinarySearchTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public boolean bstChecker(TreeNode root,long mini, long maxi){
        if(root==null) return true;
        if(root.val>=maxi || root.val<=mini) return false;
        return bstChecker(root.left,mini,root.val) && bstChecker(root.right,root.val,maxi);

    }
    public boolean isValidBST(TreeNode root) {
        return bstChecker(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
