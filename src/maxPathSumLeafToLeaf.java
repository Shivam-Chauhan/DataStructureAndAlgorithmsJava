public class maxPathSumLeafToLeaf {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)+ Auxillary Space of Recursion Stack
    void correctTree(Node root){
        if(root.left==null){
            root.left=new Node(0);
        }
        else{
            root.right=new Node(0);
        }
    }
    int maxSumFinder(Node root, int[] result){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        int leftSum=maxSumFinder(root.left,result);
        int rightSum=maxSumFinder(root.right,result);
        if(root.left!=null && root.right!=null){
            result[0]=Math.max(leftSum+rightSum+root.data, result[0]);
            return Math.max(leftSum,rightSum)+root.data;
        }
        return root.left!=null? leftSum+root.data: rightSum+root.data;
    }
    int maxPathSum(Node root)
    {
        if(root.left==null || root.right==null){
            correctTree(root);
        }
        int[] result=new int[1];
        result[0]=Integer.MIN_VALUE;
        maxSumFinder(root,result);
        return result[0];
    }
}
