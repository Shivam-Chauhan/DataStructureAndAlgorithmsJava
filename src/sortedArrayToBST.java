public class sortedArrayToBST {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public TreeNode bstMaker(int[] nums, int left, int right){
        if(left>right) return null;
        int mid=(left+right)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=bstMaker(nums,left,mid-1);
        node.right=bstMaker(nums,mid+1,right);
        return node;
    }
}
