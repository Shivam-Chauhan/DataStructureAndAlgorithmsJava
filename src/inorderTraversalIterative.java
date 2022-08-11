import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversalIterative {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty() == true) break;
                node = stack.pop();
                output.add(node.val);
                node = node.right;

            }

        }
        return output;
    }
}
