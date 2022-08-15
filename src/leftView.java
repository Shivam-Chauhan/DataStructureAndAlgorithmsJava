//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class leftView {
//    // Time Complexity :- O(N)
//    // Space Complexity :- O(N)
//    ArrayList<Integer> leftView(Node root)
//    {
//        ArrayList<Integer> output=new ArrayList<>();
//        if(root==null) return output;
//        Queue<Node> queue=new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            int size=queue.size(), flag=0;
//            while(size-->0){
//                Node node=queue.poll();
//                if(flag==0){
//                    output.add(node.data);
//                    flag=1;
//                }
//                if(node.left!=null) queue.add(node.left);
//                if(node.right!=null) queue.add(node.right);
//            }
//        }
//        return output;
//    }
//    // Time Complexity :- O(N)
//    // Space Complexity :- O(N) + Auxillary Space Of Recursion Stack
//
//    public void leftViewFinder(Node root, int level, ArrayList<Integer> output){
//        if(root==null) return;
//        if(output.size()==level){
//            output.add(root.data);
//        }
//        if(root.left!=null) leftViewFinder(root.left,level+1,output);
//        if(root.right!=null) leftViewFinder(root.right,level+1, output);
//    }
//}
