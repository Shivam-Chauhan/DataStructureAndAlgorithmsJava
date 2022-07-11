public class mergeBTree {
    // Time Complexity :- O(N+M)
    // Space Complexity :- O(1)
    public TreeNode mergeTreeImplement(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return null;
        int value=(root1==null?0:root1.val) + (root2==null?0:root2.val);
        TreeNode newNode=new TreeNode(value);
        newNode.left=mergeTreeImplement(root1==null?root1.left:null, root2==null?root2.left:null);
        newNode.right=mergeTreeImplement(root1==null?root1.right:null, root2==null?root2.right:null);
        return newNode;

    }
}
