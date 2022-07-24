class trieNode{
    trieNode[] links=new trieNode[26];
    boolean flag=false;
    trieNode(){}
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    void putKey(char ch, trieNode node){
        links[ch-'a']=node;
    }
    void setEnd(){
        flag=true;
    }
    trieNode getKey(char ch){
        return links[ch-'a'];
    }
    boolean isEnd(){
        return flag;
    }
}
public class implementATrie {
    private static trieNode root;

    public implementATrie(){
        root=new trieNode();
    }
    // Time Complexity :- O(N) where N is the length of String
    public static void insert(String word){
        trieNode node=root;
        for(char i: word.toCharArray()){
            if(!node.containsKey(i)){
                node.putKey(i, new trieNode());
            }
            node=node.getKey(i);
        }
        node.setEnd();
    }
    // Time Complexity :- O(N) where N is the length of String
    public static boolean search(String word){
        trieNode node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)) return false;
            node=node.getKey(ch);
        }
        return node.isEnd();
    }
    // Time Complexity :- O(N) where N is the length of String
    public static boolean startWith(String prefix){
        trieNode node=root;
        for(char ch:prefix.toCharArray()){
            if(!node.containsKey(ch)) return false;
            node=node.getKey(ch);
        }
        return true;
    }
}
