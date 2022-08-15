import java.util.HashSet;

public class longestKUniqueCharacterSubString {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
    public int longestkSubstr(String s, int k) {
        int left = 0, right = 0, maxi = -1;
        HashSet<Character> hashSet = new HashSet<>();
        int[] storage = new int[26];
        while (right < s.length()) {
            hashSet.add(s.charAt(right));
            storage[s.charAt(right) - 'a'] += 1;
            while (hashSet.size() > k) {
                if (--storage[s.charAt(left) - 'a'] == 0) {
                    hashSet.remove(s.charAt(left));
                }
                left += 1;
            }
            if (hashSet.size() == k) {
                maxi = Math.max(maxi, right - left + 1);
            }
            right++;
        }
        return maxi;
    }
}
