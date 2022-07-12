import java.util.*;

public class nodeAtKDistance {
    public void parentMarker(TreeNode root, Map<TreeNode, TreeNode> hashMap){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null){
                hashMap.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null){
                hashMap.put(node.right,node);
                queue.add(node.right);
            }
        }
    }
    public List<Integer> kDistanceNode(TreeNode root, TreeNode target, int k){
        HashMap<TreeNode, TreeNode > hashMap= new HashMap<>();
        List<Integer> output=new ArrayList<>();
        parentMarker(root,hashMap);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        Set<TreeNode> hashSet=new HashSet<>();
        hashSet.add(target);
        int currentLevel=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(currentLevel==k) break;
            currentLevel++;
            while(size-->=0){
                TreeNode currentNode=queue.poll();
                if(currentNode.left!=null && !hashSet.contains(currentNode.left)){
                    queue.add(currentNode.left);
                    hashSet.add(currentNode.left);
                }
                if(currentNode.right!=null && !hashSet.contains(currentNode.right)){
                    queue.add(currentNode.right);
                    hashSet.add(currentNode.right);
                }
                if(hashMap.get(currentNode)!=null && !hashSet.contains(hashMap.get(currentNode))){
                    queue.add(hashMap.get(currentNode));
                    hashSet.add(hashMap.get(currentNode));
                }
            }
        }
        while(queue.size()>0){
            output.add(queue.poll().val);
        }
        return output;
    }
}
