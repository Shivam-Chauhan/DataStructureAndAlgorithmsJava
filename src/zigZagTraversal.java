import java.util.*;

public class zigZagTraversal {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Auxillary Space of Recursion Stack
    public void zigZag(TreeNode root,List<List<Integer>> output){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int counter=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tempStore=new ArrayList<>();
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
            if(counter%2==0){
                output.add(tempStore);
            }
            else{
                Collections.reverse(tempStore);
                 output.add(tempStore);
            }
            counter++;
        }
    }
}
