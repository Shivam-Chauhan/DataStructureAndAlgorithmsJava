import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightViewOfBTree {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public List<Integer> rightViewFinder(TreeNode root){
        List<Integer> output=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int sizeOfQueue=queue.size();
            while(sizeOfQueue>0){
                TreeNode node=queue.poll();
                if(sizeOfQueue==1) output.add(node.val);

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                sizeOfQueue-=1;
            }
        }
        return output;
    }
}
