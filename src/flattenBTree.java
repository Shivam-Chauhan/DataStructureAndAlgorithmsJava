public class flattenBTree {

    TreeNode prev = null;
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // link :- https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
