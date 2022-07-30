public class shortestCommonSuperSequence {
    public static String superSequence(String a, String b) {
        int row = a.length(), col = b.length();
        int[][] grid = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    grid[i][j] = 1 + grid[i - 1][j - 1];
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        int i = row, j = col;
        StringBuilder str = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                str.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (grid[i - 1][j] > grid[i][j - 1]) {
                str.append(a.charAt(i - 1));
                i--;
            } else {
                str.append(b.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            str.append(a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            str.append(b.charAt(j - 1));
            j--;
        }
        return str.reverse().toString();
    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    // link :- https://www.codingninjas.com/codestudio/problems/shortest-supersequence_4244493?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static String shortestSupersequence(String a, String b) {
        return superSequence(a, b);
    }
}
