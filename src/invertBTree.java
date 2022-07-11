public class invertBTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public void invertTreeFinder(TreeNode root){
        if(root==null) return;
        invertTreeFinder(root.left);
        invertTreeFinder(root.right);

        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;

    }
}
