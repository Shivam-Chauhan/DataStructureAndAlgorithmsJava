import java.util.LinkedList;
import javafx.util.Pair;

public class maxWidthOfBTree {
    // Time Complexity :- ~ O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public int maxWidthOfBinaryTree(TreeNode root){
        int result=Integer.MIN_VALUE;
        Queue<Pair<TreeNode, Integer>> queue=new LinkedList<>();
        queue.add(new Pair<>(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            int maxi=Integer.MIN_VALUE, mini=Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                Pair<TreeNode, Integer> nodalVal=queue.poll();
                TreeNode node=nodalVal.getKey();
                int index=nodalVal.getValue();
                maxi=Math.max(maxi,index);
                mini=Math.min(mini,index);
                if(node.left!=null) queue.add(new Pair<>(node.left,2*index+1));
                if(node.right!=null) queue.add(new Pair<>(node.right,2*index+2));
            }
            result=Math.max(result,maxi-mini+1);
        }
        return result;
    }
}
