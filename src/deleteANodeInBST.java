public class deleteANodeInBST {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // link :- hhttps://leetcode.com/problems/delete-node-in-a-bst/
    public TreeNode findRightMostChild(TreeNode root) {
        if (root.right == null) return root;
        return findRightMostChild(root.right);
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode rightChild = root.right;
        TreeNode rightMostChild = findRightMostChild(root.left);
        rightMostChild.right = rightChild;
        return root.left;
    }

    public TreeNode deleteNodeFinder(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) return helper(root);
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeFinder(root, key);
    }
}
