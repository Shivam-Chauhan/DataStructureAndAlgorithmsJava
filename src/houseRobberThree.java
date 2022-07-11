class TreeNode {
    int val;
    TreeNode left,right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class houseRobberThree {
    public class NodePair{
        int withoutRobbery=0;
        int withRobbery=0;
    }
    // Time Complexity :- O(N)
    // Space Complexity :- O(1) + Recursive Space of Stack
    public NodePair houseRobberFinder(TreeNode root){
        if(root==null) return new NodePair();
        NodePair left=houseRobberFinder(root.left);
        NodePair right=houseRobberFinder(root.right);
        NodePair result=new NodePair();
        result.withRobbery=left.withoutRobbery+root.val+right.withoutRobbery;
        result.withoutRobbery=Math.max(left.withoutRobbery, left.withRobbery)+
                Math.max(right.withoutRobbery,right.withRobbery);
        return result;

    }
    public static void main(String[] args) {
        houseRobberThree obj=new houseRobberThree();
        TreeNode root=new TreeNode(10);
        if(root==null) System.out.println(0);
        else{
            NodePair result=obj.houseRobberFinder(root);
            System.out.println(Math.max(result.withoutRobbery, result.withRobbery));
        }
    }
}
