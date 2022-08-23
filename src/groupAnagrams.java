import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    // Time Complexity :- O(N*M*Log(M))
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        for (String string : strs) {
            char[] chr = string.toCharArray();
            Arrays.sort(chr);
            String tempString = String.valueOf(chr);
            if (!hashMap.containsKey(tempString)) hashMap.put(tempString, new ArrayList<>());
            hashMap.get(tempString).add(string);
        }
        for (String temp : hashMap.keySet()) {
            output.add(hashMap.get(temp));
        }
        return output;
    }
}
