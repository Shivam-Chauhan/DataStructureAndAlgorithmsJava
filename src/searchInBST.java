public class searchInBST {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // link :- https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/
    public TreeNode searcher(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode leftChild = null, rightChild = null;
        if (root.val > val) leftChild = searcher(root.left, val);
        else rightChild = searcher(root.right, val);
        if (leftChild != null || rightChild != null) return leftChild != null ? leftChild : rightChild;
        return null;
    }
}
