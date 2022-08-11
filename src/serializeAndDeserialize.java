import java.util.LinkedList;
import java.util.Queue;

public class serializeAndDeserialize {
    // Encodes a tree to a single string.
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // link :- https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                str.append("n ");
                continue;
            }
            str.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] value = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        queue.add(root);
        for (int i = 1; i < value.length; i++) {
            TreeNode node = queue.poll();
            if (!value[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                node.left = left;
                queue.add(left);
            }
            if (!value[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
