import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public void levelOrderImpl(TreeNode root,List<List<Integer>> output){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> tempStore=new ArrayList<>();
            while(size>0){
                TreeNode node=queue.poll();
                tempStore.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                size-=1;
            }
            output.add(tempStore);
        }
    }
}
