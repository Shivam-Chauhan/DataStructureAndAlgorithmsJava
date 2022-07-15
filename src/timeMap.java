import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



// Time Complexity :- ~ O(Log(N))
// Space Complexity :- O(N)
public class timeMap {
    class NodeValue{
        String value;
        int timeStamp;
        NodeValue(String value, int timeStamp){
            this.value=value;
            this.timeStamp=timeStamp;
        }
    }
    Map<String, List<NodeValue>> storage;
    public timeMap(){
        storage=new HashMap<>();
    }
    public void set(String key, String value, int timeStamp){
        storage.putIfAbsent(key,new ArrayList<>());
        storage.get(key).add(new NodeValue(value, timeStamp));
    }
    public String get(String key,int timeStamp){
        List<NodeValue> elements=storage.get(key);
        if(elements==null) return "";
        int low=0,high=elements.size()-1;
        while(low<high-1){
            int mid=low+(high-low)/2;
            NodeValue node=elements.get(mid);
            if(node.timeStamp==timeStamp) return node.value;
            else if(node.timeStamp<timeStamp) low=mid+1;
            else high=mid-1;
        }
        if(elements.get(high).timeStamp<=timeStamp) return elements.get(high).value;
        else if(elements.get(low).timeStamp<=timeStamp) return elements.get(low).value;
        return "";
    }
}
