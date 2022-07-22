import java.util.HashMap;
import java.util.PriorityQueue;
class reOrganizeStringNode implements Comparable<reOrganizeStringNode>{
    int freq;
    char character;
    public reOrganizeStringNode(int freq, char charcter){
        this.freq=freq;
        this.character=charcter;
    }
    public int compareTo(reOrganizeStringNode o){
        return o.freq-this.freq;
    }
}

public class reorganizeString {
    // Time Complexity :- O(N*Log(K))
    // Space Complexity :- O(K) + O(N)
    public String reorganizeStringFinder(String s){
        PriorityQueue<reOrganizeStringNode> maxHeap = new PriorityQueue<>();
        HashMap<Character, Integer> hashMap=new HashMap<>();
        for(char element: s.toCharArray()){
            int count=hashMap.getOrDefault(element,0)+1;
            if(count>(s.length()+1)/2) return "";
            hashMap.put(element,count);
        }
        for(Character key: hashMap.keySet()){
            maxHeap.add(new reOrganizeStringNode(hashMap.get(key),key));
        }
        StringBuilder output=new StringBuilder();
        while(!maxHeap.isEmpty()){
            reOrganizeStringNode node1=maxHeap.poll();
            output.append(node1.character);
            node1.freq--;
            reOrganizeStringNode node2=null;
            if(maxHeap.size()>0){
                node2=maxHeap.poll();
                output.append(node2.character);
                node2.freq--;

            }
            if(node1.freq>0) maxHeap.add(new reOrganizeStringNode(node1.freq, node1.character));

            if(node2!=null && node2.freq>0) maxHeap.add(new reOrganizeStringNode(node2.freq, node2.character));
        }
        return output.toString();
    }
    public static void main(String[] args) {
        String s="adsahjdhasdkshdasdjhasdjkashdjkasdasjdhasd";
        reorganizeString obj=new reorganizeString();
        System.out.println(obj.reorganizeStringFinder(s));

    }
}
