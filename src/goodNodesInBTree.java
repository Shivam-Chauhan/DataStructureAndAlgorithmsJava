public class goodNodesInBTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public void goodNodesFinder(TreeNode root,int maxi, int[] counter){
        if(root==null) return;
        if(root.val>=maxi){
            maxi=root.val;
            counter[0]+=1;
        }
        goodNodesFinder(root.left,maxi,counter);
        goodNodesFinder(root.right,maxi,counter);
    }
}
