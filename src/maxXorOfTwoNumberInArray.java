class maxXorNode {
    maxXorNode[] links;
    public maxXorNode(){
        links=new maxXorNode[2];
    }
    public maxXorNode get(int bit){
        return links[bit];
    }
    public void put(int bit, maxXorNode node){
        links[bit]=node;
    }
    public boolean containsKey(int bit){
        return links[bit]!=null;
    }
}
// Time Complexity :- O(32*N) + O(32*N)
public class maxXorOfTwoNumberInArray {
    maxXorNode root;
    public maxXorOfTwoNumberInArray(){
        root=new maxXorNode();
    }
    public void insert(int element){
        maxXorNode node = root;
        for(int i=31;i>=0;i--){
            int bit=(element>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new maxXorNode());
            }
            node=node.get(bit);
        }
    }

    public int getMax(int element){
        maxXorNode node=root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit=(element>>i) & 1;
            if(node.containsKey(1-bit)){
                maxNum=maxNum | (1<<i);
                node=node.get(1-bit);
            }
            else {
                node=node.get(bit);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        maxXorOfTwoNumberInArray obj=new maxXorOfTwoNumberInArray();
        int maxNum=0;
        for(int i: nums) obj.insert(i);
        for(int i: nums){
            maxNum=Math.max(maxNum,obj.getMax(i));

        }
        System.out.println(maxNum);
    }


}
