public class isBalancedBTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public int height(TreeNode root, boolean[] ans){
        if(root==null) return 0;

        int lh=height(root.left,ans);
        int rh=height(root.right,ans);
        if(Math.abs(lh-rh)>1) ans[0]=false;
        return Math.max(lh,rh)+1;

    }
}
