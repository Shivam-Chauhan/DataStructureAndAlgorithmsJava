import java.util.HashMap;

public class decodeWays {
    // Recursive Solution
    // Time Complexity :- O(2^N)
    // Space Complexity :- O(1) + Recursive Space of Stack
    public int decodeWaysFinder(String s, int index){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        int result=decodeWaysFinder(s,index+1);
        if(index+1<s.length() && (s.charAt(index)=='1' || s.charAt(index)=='2' && s.charAt(index+1)<'7')){
            result+=decodeWaysFinder(s, index+2);
        }
        return result;
    }
    // Recursive Solution + Memo
    // Time Complexity :- O(2^N)
    // Space Complexity :- O(N) + Recursive Space of Stack
    public int decodeWaysOptimalFinder(String s, int index, HashMap<Integer,Integer> hashMap){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(hashMap.containsKey(index)==true) return hashMap.get(index);
        int result=decodeWaysOptimalFinder(s,index+1,hashMap);
        if(index+1<s.length() && (s.charAt(index)=='1' || s.charAt(index)=='2' && s.charAt(index+1)<'7')){
            result+=decodeWaysOptimalFinder(s,index+2,hashMap);
        }
        hashMap.put(index,result);
        return result;
    }
    public static void main(String[] args) {
        String s="123113";
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        decodeWays obj=new decodeWays();
        System.out.println(obj.decodeWaysFinder(s,0));
        System.out.println(obj.decodeWaysOptimalFinder(s,0,hashMap));
    }
}
