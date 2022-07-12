public class maxDepthBTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int maxDepthFinder(TreeNode root){
        if(root==null) return 0;

        return Math.max(maxDepthFinder(root.left), maxDepthFinder(root.right))+1;
    }
}
