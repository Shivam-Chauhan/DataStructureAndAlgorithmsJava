import java.util.HashMap;
import java.util.HashSet;

public class longestSubStringWithOutRepeatingCharacters {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int longestSubStringWithOutRepeatingCharactersBest(String str){
        HashMap<Character,Integer> storage=new HashMap<>();
        int leftIndex=0,rightIndex=0,maxLength=0;
        while(rightIndex<str.length()){
            if(storage.containsKey(str.charAt(rightIndex))==true){
                leftIndex=Math.max(storage.get(str.charAt(rightIndex))+1,leftIndex);
            }
            storage.put(str.charAt(rightIndex),rightIndex);
            maxLength=Math.max(maxLength,rightIndex-leftIndex+1);
            rightIndex++;
        }
        return maxLength;
    }
    // Time Complexity :- O(2*N)
    // Space Complexity :- O(N)
    public int longestSubStringWithOutRepeatingCharactersBetter(String str){
        HashSet<Character> storage=new HashSet<Character>();
        int leftIndex=0,rightIndex=0,maxLength=0;
        while(rightIndex<str.length()){
            if(storage.contains(str.charAt(rightIndex))==false) maxLength=Math.max(maxLength,rightIndex-leftIndex+1);
            while(storage.contains(str.charAt(rightIndex))==true){
                storage.remove(str.charAt(leftIndex++));
            }
            storage.add(str.charAt(rightIndex++));
        }
        maxLength=Math.max(maxLength,rightIndex-leftIndex+1);
        return maxLength;
    }
    public static void main(String[] args) {
        String str="geeksforgeeks";
        longestSubStringWithOutRepeatingCharacters obj=new longestSubStringWithOutRepeatingCharacters();
//        System.out.println(obj.longestSubStringWithOutRepeatingCharactersBetter(str));

        System.out.println(obj.longestSubStringWithOutRepeatingCharactersBest(str));
    }
}
