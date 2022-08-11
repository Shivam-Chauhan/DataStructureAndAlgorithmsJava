import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrderTraversalIterative {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> output=new ArrayList<>();
        if(root==null) return output;
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            output.add(node.val);
            if(node.right!=null) stack.add(node.right);
            if(node.left!=null) stack.add(node.left);
        }
        return output;
    }
}
