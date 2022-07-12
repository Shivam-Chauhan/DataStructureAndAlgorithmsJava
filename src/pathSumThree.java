public class pathSumThree {
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public void checker(TreeNode root, int target,int summation ,int[] ans){
        if(root==null) return;
        summation+=root.val;
        if(target==summation) ans[0]+=1;
        checker(root.left,target,summation,ans);
        checker(root.right,target,summation,ans);

    }
    public void targetMaker(TreeNode root, int target, int[] ans){
        if(root==null) return;
        checker(root,target,0,ans);
        targetMaker(root.left,target,ans);
        targetMaker(root.right,target,ans);
    }
}
