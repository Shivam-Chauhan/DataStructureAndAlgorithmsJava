import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wordLadder {
    // Time Complexity :- O(N*N*W)
    // Space Complexity :- O(N+N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> mySet=new HashSet<>();
        boolean isPresent=false;
        for(String st:wordList){
            if(endWord.compareTo(st)==0) isPresent=true;
            mySet.add(st);
        }
        if(isPresent==false) return 0;
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int depth=0;
        while(!queue.isEmpty()){
            depth++;
            int queueSize=queue.size();
            while(queueSize-->0){
                String curr=queue.poll();
                for(int i=0;i<curr.length();i++){
                    char[] temp=curr.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        temp[i]=ch;
                        String temper=new String(temp);
                        if(curr.compareTo(temper)==0) continue;
                        if(temper.compareTo(endWord)==0) return depth+1;
                        if(mySet.contains(temper)){
                            queue.add(temper);
                            mySet.remove(temper);
                        }
                    }
                }
            }
        }
        return 0;

    }
}
