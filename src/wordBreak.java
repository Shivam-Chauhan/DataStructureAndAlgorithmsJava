import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    // Time Complexity :- O(N*2^N)
    // Space Complexity :- O(1) + Recursive Space Stack
    public boolean wordBreakRecursive(String s, HashSet<String> hashSet){

        if(s.length()==0) return true;
        for(int i=1;i<=s.length();i++){
            System.out.println(s.substring(0,i)+" "+s.substring(i));
            if(hashSet.contains(s.substring(0,i)) && wordBreakRecursive(s.substring(i),hashSet)==true) return true;
        }
        return false;
    }

    // Time Complexity :- O(N^2)
    // Space Complexity :- O(N) + Recursive Space Stack
    public int wordBreakMemo(String s, HashSet<String> hashSet, int[] storage, int index){

        if(index>=s.length()) return 1;
        if(storage[index]!=0) return storage[index];
        for(int i=index+1;i<=s.length();i++){
            if(hashSet.contains(s.substring(index,i)) && wordBreakMemo(s,hashSet,storage,i)!=0)
                return storage[index]=1;
        }
        return storage[index]=0;
    }
    public static void main(String[] args) {
        String s="leetcode";
        List<String> wordDict=new ArrayList<>();
        int[] storage=new int[s.length()];
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak obj= new wordBreak();
        HashSet<String> hashSet= new HashSet<>(wordDict);
        System.out.println(obj.wordBreakRecursive(s,hashSet));
        System.out.println(obj.wordBreakMemo(s,hashSet,storage,0));
    }
}
