public class diameterOfBTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public int diameterFinder(TreeNode root, int[] ans){
        if(root==null) return 0;
        int left=diameterFinder(root.left,ans);
        int right=diameterFinder(root.right,ans);
        ans[0]=Math.max(left+right,ans[0]);
        return Math.max(left,right)+1;
    }
}
