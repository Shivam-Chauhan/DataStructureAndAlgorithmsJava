import java.util.HashMap;
import java.util.Map;


// Time Complexity :- O(1)
// Space Complexity :- O(N)
public class LRUCache {
    Node head= new Node(0,0), tail=new Node(0,0);
    Map<Integer,Node> mapper=new HashMap<>();
    int capacity;
    public LRUCache(int _cap){
        capacity=_cap;
        head.next=tail;
        tail.prev=head;
    }
    public int get(int key){
        if(mapper.containsKey(key)){
            Node node=mapper.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key,int value){
        if(mapper.containsKey(key)){
            remove(mapper.get(key));
        }
        if(mapper.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    public void insert(Node node){
        mapper.put(node.key,node);
        Node headNext=head.next;
        head.next=node;
        node.prev=head;
        headNext.prev=node;
        node.next=headNext;
    }
    public void remove(Node node){
        mapper.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public static void main(String[] args) {
        LRUCache obj=new LRUCache(3);

    }

}
