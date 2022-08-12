public class insertInBST {
    // Time Complexity :- O(Log(N))
    // Space Complexity :- O(1)
    // link :- https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode curr=root;
        while(true){
            if(curr.val<=val){
                if(curr.right!=null) curr=curr.right;
                else{
                    curr.right=new TreeNode(val);
                    break;
                }
            }
            else{
                if(curr.left!=null) curr=curr.left;
                else{
                    curr.left=new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
