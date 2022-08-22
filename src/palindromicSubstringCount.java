public class palindromicSubstringCount {
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/palindromic-substrings/
    public int countPalindromicSubstring(String string, int left, int right) {
        int counter = 0;
        while (left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)) {
            left--;
            right++;
            counter++;
        }
        return counter;
    }

    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countPalindromicSubstring(s, i, i + 1) + countPalindromicSubstring(s, i, i);
        }
        return result;
    }
}
