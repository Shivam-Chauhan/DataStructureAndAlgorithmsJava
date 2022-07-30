public class longestCommonSubsequence {
    public static int lcsFinder(String s, String t, int index1, int index2, int[][] grid) {
        if (index1 < 0 || index2 < 0) return 0;
        if (grid[index1][index2] != -1) return grid[index1][index2];
        if (s.charAt(index1) == t.charAt(index2)) {
            return grid[index1][index2] = 1 + lcsFinder(s, t, index1 - 1, index2 - 1, grid);
        }
        return grid[index1][index2] = Math.max(lcsFinder(s, t, index1 - 1, index2, grid), lcsFinder(s, t, index1, index2 - 1, grid));
    }
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/longest-common-subsequence_624879?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static int lcs(String s, String t) {
        int[][] grid = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) grid[i][j] = -1;
        }
        return lcsFinder(s, t, s.length() - 1, t.length() - 1, grid);
    }
}
