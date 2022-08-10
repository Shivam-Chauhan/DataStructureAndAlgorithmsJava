import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class deleteANodeReturnForest {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/delete-nodes-and-return-forest/
    // Sol Link :- https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/328860/Simple-Java-Sol
    public TreeNode delNodeFinder(TreeNode root, Set<Integer> set, List<TreeNode> output) {
        if (root == null) return null;
        root.left = delNodeFinder(root.left, set, output);
        root.right = delNodeFinder(root.right, set, output);
        if (set.contains(root.val)) {
            if (root.left != null) output.add(root.left);
            if (root.right != null) output.add(root.right);
            return null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> output = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        root = delNodeFinder(root, set, output);
        if (root != null) output.add(root);
        return output;

    }
}
