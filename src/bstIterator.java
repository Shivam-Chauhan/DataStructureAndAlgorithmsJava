import java.util.Stack;

public class bstIterator {
    // Time Complexity :- ~ O(1)
    // Space Complexity :- O(H)
    private Stack<TreeNode> stack=new Stack<>();
    public bstIterator(TreeNode root){
        pushAll(root);
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    public int next(){
        TreeNode temp=stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    private void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

}
