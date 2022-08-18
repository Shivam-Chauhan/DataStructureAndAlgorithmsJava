import java.util.ArrayList;
//class trieNode{
//    trieNode[] links= new trieNode[2];
//    public boolean containsKey(int bit){
//        return (links[bit]!=null);
//    }
//    public trieNode get(int bit){
//        return links[bit];
//    }
//    public void put(int bit, trieNode node){
//        links[bit]=node;
//    }
//}
// Time Complexity :- O(N*M) + O(N*M) // Where M is the Length of String in AVG
// Space Complexity :- Can't be predicted
// Link :- https://www.codingninjas.com/codestudio/problems/maximum-xor_973113?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
class trieImplementor{
    private static trieNode root;
    public trieImplementor(){
        root=new trieNode();
    }
    public static void insert(int element){
        trieNode node=root;
        for(int i=31;i>=0;i--){
            int bit=(element>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit,new trieNode());
            }
            node=node.get(bit);
        }
    }

    public static int maximumVal(int element){
        trieNode node=root;
        int maximum=0;
        for(int i=31;i>=0;i--){
            int bit=(element>>i)&1;
            if(node.containsKey(1-bit)==true){
                maximum=maximum | (1<<i);
                node=node.get(1-bit);
            }
            else node=node.get(bit);
        }
        return maximum;
    }
}
public class maxXorTrie {
    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2)
    {
        trieImplementor obj=new trieImplementor();
        int maxiVal=0;
        for(int i: arr1) obj.insert(i);
        for(int i: arr2) maxiVal=Math.max(maxiVal,obj.maximumVal(i));

        return maxiVal;
    }
}
