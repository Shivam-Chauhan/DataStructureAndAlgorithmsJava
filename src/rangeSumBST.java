public class rangeSumBST {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stacka
    public int ranger(TreeNode root, int low, int right){
        if(root==null) return 0;
        if(root.val<low) return ranger(root.right,low,right);
        if(root.val>right) return ranger(root.left,low,right);
        return root.val+ranger(root.left,low,right)+ranger(root.right,low,right);
    }
}
