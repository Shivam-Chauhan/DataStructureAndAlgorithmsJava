public class childrenSumParent {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    public static int isSatisfied(TreeNode root, int[] output){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        int rootLeft=isSatisfied(root.left,output);
        int rootRight=isSatisfied(root.right,output);
        if(rootLeft+rootRight!=root.val) output[0]=0;
        return root.val;
    }
    public static int isSumProperty(TreeNode root)
    {
        int[] output=new int[]{1};
        isSatisfied(root,output);
        return output[0];
    }
}
