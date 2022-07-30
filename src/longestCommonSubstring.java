public class longestCommonSubstring {
    public static int longestCommonSubstringFinder(String str1, String str2) {
        int row = str1.length(), col = str2.length();
        int[][] grid = new int[row + 1][col + 1];
        int maxi = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) grid[i][j] = 1 + grid[i - 1][j - 1];
                maxi = Math.max(maxi, grid[i][j]);
            }
        }
        return maxi;
    }
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/longest-common-substring_1235207?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int lcs(String str1, String str2) {
        return longestCommonSubstringFinder(str1, str2);
    }
}
