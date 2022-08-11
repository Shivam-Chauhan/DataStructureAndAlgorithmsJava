import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class nodeTrav {
    TreeNode node;
    int label;
    public nodeTrav(TreeNode node, int label) {
        this.node = node;
        this.label = label;
    }
}

public class preInPostIterative {
    public List<Integer> allTraversal(TreeNode root) {
        Stack<nodeTrav> stack = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) return inOrder;
        stack.add(new nodeTrav(root, 1));
        while (!stack.isEmpty()) {
            nodeTrav temp = stack.pop();
            if (temp.label == 1) {
                preOrder.add(temp.node.val);
                stack.add(new nodeTrav(temp.node, temp.label + 1));
                if (temp.node.left != null) {
                    stack.add(new nodeTrav(temp.node.left, 1));
                }
            } else if (temp.label == 2) {
                inOrder.add(temp.node.val);
                stack.add(new nodeTrav(temp.node, temp.label + 1));
                if (temp.node.right != null) {
                    stack.add(new nodeTrav(temp.node.right, 1));
                }
            } else {
                postOrder.add(temp.node.val);
            }
        }
        return inOrder;
    }
}
