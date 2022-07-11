public class isSubTree {
    // Time Complexity :- O(N*M)
    // Space Complexity :- Auxillary Space of Recursion Stack
    public boolean checkForNode(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        else if(root==null || subRoot==null) return false;
        else if(root.val==subRoot.val && checkForNode(root.left,subRoot.left) && checkForNode(root.right,subRoot.right)){
            return true;
        }
        return false;
    }
    public boolean isSubTreeChecker(TreeNode root, TreeNode subRoot){
        if(root==null) return false;
        else if(subRoot==null) return true;
        else if(checkForNode(root,subRoot)) return true;
        return isSubTreeChecker(root.left,subRoot) || isSubTreeChecker(root.right,subRoot);
    }
}
