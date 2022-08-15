class mapSumNode{
    mapSumNode[] links;
    int summation;
    public mapSumNode(){
        links=new mapSumNode[26];
        summation=0;
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public mapSumNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch, mapSumNode node){
        links[ch-'a']=node;
    }
    public void addSummation(int value){
        summation=value;
    }
    public int getSummation(){
        return summation;
    }
}
public class mapSum {
    mapSumNode root;
    public mapSum(){
        root=new mapSumNode();
    }
    public void insert(String key, int val){
        mapSumNode node=root;
        for(char ch: key.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new mapSumNode());
            }
            node.addSummation(val);
            node.get(ch);
        }
    }
    public int sum(String prefix){
        mapSumNode node=root;
        int ans=0;
        for(char ch: prefix.toCharArray()){
            if(!node.containsKey(ch)) return ans;
            ans=node.getSummation();
            node=node.get(ch);
        }
        return ans;
    }

}
