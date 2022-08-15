//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Pair{
//    int state;
//    Node root;
//
//    Pair(Node root, int state){
//        this.state = state;
//        this.root = root;
//    }
//}
//public class topViewOfBinaryTree {
//    static ArrayList<Integer> topView(Node root)
//    {
//        Queue<Pair> queue=new LinkedList<>();
//        ArrayList<Integer> output=new ArrayList<>();
//        HashMap<Integer,Integer> hashMap=new HashMap<>(); // (verticalAlignment, nodeData)
//        queue.add(new Pair(root,0));
//        int maxi=Integer.MIN_VALUE, mini=Integer.MAX_VALUE;
//        while(!queue.isEmpty()){
//            Pair node=queue.poll();
//            maxi=Math.max(maxi,node.state);
//            mini=Math.min(mini,node.state);
//            if(hashMap.containsKey(node.state)==false){
//                hashMap.put(node.state,node.root.data);
//            }
//            if(node.root.left!=null) queue.add(new Pair(node.root.left,node.state-1));
//            if(node.root.right!=null) queue.add(new Pair(node.root.right,node.state+1));
//        }
//        for(int i=mini;i<=maxi;i++){
//            output.add(hashMap.get(i));
//        }
//        return output;
//    }
//}
