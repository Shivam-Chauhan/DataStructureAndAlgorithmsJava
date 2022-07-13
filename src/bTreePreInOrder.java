import java.util.HashMap;
import java.util.Map;

public class bTreePreInOrder {
    // Time Complexity :- ~ O(N)
    // Space Complexity :- O(N)
    public TreeNode builder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> hashMap){
        if(inStart>inEnd || preStart>preEnd) return null;
        int index=hashMap.get(preorder[preStart]);
        int numLeft=index-inStart;
        TreeNode root=new TreeNode(preorder[preStart]);
        root.left=builder(preorder,preStart+1,preStart+numLeft,inorder,inStart,index-1,hashMap);
        root.right=builder(preorder,preStart+numLeft+1,preEnd,inorder,index+1,inEnd,hashMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hashMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hashMap.put(inorder[i],i);
        }
        return builder(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hashMap);
    }
}
