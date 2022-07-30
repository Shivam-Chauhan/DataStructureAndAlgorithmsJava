public class distinctSubsequence {
    public int numDistinctFinder(String s, String t, int index1, int index2, int[][] grid) {
        if (index2 < 0) return 1;
        if (index1 < 0) return 0;
        if (grid[index1][index2] != -1) return grid[index1][index2];
        if (s.charAt(index1) == t.charAt(index2)) {
            return grid[index1][index2] = numDistinctFinder(s, t, index1 - 1, index2 - 1, grid) + numDistinctFinder(s, t, index1 - 1, index2, grid);
        }
        return grid[index1][index2] = numDistinctFinder(s, t, index1 - 1, index2, grid);
    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    // link :- https://leetcode.com/problems/distinct-subsequences/
    public int numDistinct(String s, String t) {
        int[][] grid = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) grid[i][j] = -1;
        }
        return numDistinctFinder(s, t, s.length() - 1, t.length() - 1, grid);
    }
}

