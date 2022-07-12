public class sumOfLeftLeaf {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public int sumOfLeaf(TreeNode root){
        if(root==null) return 0;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            return root.left.val+ sumOfLeaf(root.right);
        }
        return sumOfLeaf(root.left)+ sumOfLeaf(root.right);
    }
}
