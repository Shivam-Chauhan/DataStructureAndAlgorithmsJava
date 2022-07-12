import java.util.List;

public class binaryTreePaths {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public void binaryTreePathFinder(TreeNode root,List<String> output, List<Integer> tempStore){
        if(root==null) return;
        if(root.left==null && root.right==null){
            StringBuilder str=new StringBuilder();
            int i;
            for(i=0;i<tempStore.size();i++){
                str.append(tempStore.get(i).toString());
                str.append("->");
            }
            str.append(root.val);
            output.add(str.toString());
            return;
        }
        tempStore.add(root.val);
        binaryTreePathFinder(root.left,output,tempStore);
        binaryTreePathFinder(root.right,output,tempStore);
        tempStore.remove(tempStore.size()-1);

    }
}
