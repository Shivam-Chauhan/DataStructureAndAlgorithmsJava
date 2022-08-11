public class countCompleteTreeNode {
    // Time Complexity :- O(Log(N)^2)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // link :- https://leetcode.com/problems/count-complete-tree-nodes/
    public int leftHeightCounter(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    public int rightHeightCounter(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }

    public int countNodesFinder(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftHeightCounter(root);
        int rightHeight = rightHeightCounter(root);
        if (leftHeight == rightHeight) return ((1 << leftHeight) - 1);

        return 1 + countNodesFinder(root.left) + countNodesFinder(root.right);
    }

    public int countNodes(TreeNode root) {
        return countNodesFinder(root);
    }
}
