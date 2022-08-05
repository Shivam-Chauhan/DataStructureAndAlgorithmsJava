public class minInsertionToMakeStringPalindrome {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    public int longestCommonSub(String string1, String string2, int index1, int index2, int[][] grid) {
        if (index1 < 0 || index2 < 0) return 0;
        if (grid[index1][index2] != 0) return grid[index1][index2];
        if (string1.charAt(index1) == string2.charAt(index2))
            return grid[index1][index2] = 1 + longestCommonSub(string1, string2, index1 - 1, index2 - 1, grid);
        return grid[index1][index2] = Math.max(
                longestCommonSub(string1, string2, index1 - 1, index2, grid),
                longestCommonSub(string1, string2, index1, index2 - 1, grid));
    }

    public int minInsertions(String s) {
        StringBuilder newString = new StringBuilder(s);
        newString.reverse();
        int[][] grid = new int[s.length() + 1][s.length() + 1];
        String string = newString.toString();
        return s.length() - longestCommonSub(s, string, s.length() - 1, string.length() - 1, grid);
    }
}
