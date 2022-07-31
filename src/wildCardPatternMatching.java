public class wildCardPatternMatching {
    public static boolean wildCardFinder(String pattern, String text, int index1, int index2, int[][] grid) {
        if (index1 < 0 && index2 < 0) return true;
        if (index1 < 0 && index2 >= 0) return false;
        if (index1 >= 0 && index2 < 0) {
            for (int i = 0; i <= index1; i++) {
                if (pattern.charAt(i) != '*') return false;
            }
            return true;
        }
        if (grid[index1][index2] != -1) return grid[index1][index2] == 1;
        if (pattern.charAt(index1) == text.charAt(index2) || pattern.charAt(index1) == '?') {
            boolean ans = wildCardFinder(pattern, text, index1 - 1, index2 - 1, grid);
            grid[index1][index2] = (ans == true ? 1 : 0);
            return ans;
        }


        if (pattern.charAt(index1) == '*') {
            boolean ans = wildCardFinder(pattern, text, index1 - 1, index2, grid) || wildCardFinder(pattern, text, index1, index2 - 1, grid);
            grid[index1][index2] = (ans == true ? 1 : 0);
            return ans;
        }
        grid[index1][index2] = 0;
        return false;
    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    public boolean isMatch(String text, String pattern) {
        int[][] grid = new int[pattern.length()][text.length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) grid[i][j] = -1;
        }

        return wildCardFinder(pattern, text, pattern.length() - 1, text.length() - 1, grid);
    }
}
