public class lowestCommonAncestor {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // link :- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode leftRoot = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRoot = lowestCommonAncestor(root.right, p, q);
        if (leftRoot == null) return rightRoot;
        else if (rightRoot == null) return leftRoot;
        else return root;
    }
}

